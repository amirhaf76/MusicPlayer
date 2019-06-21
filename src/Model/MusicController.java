package Model;

import javazoom.jl.decoder.JavaLayerException;
import java.io.*;
import static Model.CONTROL.*;

public class MusicController extends MusicPlayer {

    // file
    private Music presentMusic;
    private BufferedInputStream buffer;
    private int indexOfMusic;

    // player
    private MachinePlayer player;

    // frames and time
    private long numberOfFrame;
    private int lastTime = 0;


    private Object lock = new Object(); // make player lock

    private CONTROL command;

    // playing mode
    private CONTROL repetitionState = ONECE;
    private boolean shuffle = false;


    public MusicController() throws IOException, JavaLayerException {

        prepareMusic();

        numberOfFrame = player.findNumbersOfFrame();

        player.close(); // close player and buffer

        prepareMusic(); // because player and buffer is closed
        command = CONTROL.NOTSTARTED;
        this.start();
    }


    private void playMusic() throws IOException, JavaLayerException {

        Thread runPlayer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (command.equals(CONTROL.PLAYING)) {

                        if (!player.play(1)) {
                            command = CONTROL.STOP;
                            break; // finish music
                        } else {
                            numberOfFrame++;
                        }

                        synchronized (this) {

                            switch (command) {
                                case PAUSE:
                                    wait();
                                    break;

                                case NEXT:
                                case PREVIOUS:
                                    command = CONTROL.STOP;
                                    break;
                                default:
                            }
                        }
                    }

                } catch (JavaLayerException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Music player");

        runPlayer.start(); // if song reach to the end, player close buffer

    }


    public void start() throws IOException, JavaLayerException {
        synchronized (this) {
            switch (command) {
                case NOTSTARTED:
                    command = CONTROL.PLAYING;
                    playMusic();
                    break;

                case PAUSE:
                    command = CONTROL.PLAYING;
                    notifyAll();
                    break;
                default:

            }
        }
    }


    public void stopMusic() {
        synchronized (this) {
            if (command.equals(CONTROL.PLAYING) ||
                    command.equals(CONTROL.PAUSE)) {
                command = CONTROL.STOP;
            }
        }
    }

    public void nextMusic(File musicFile) {
        synchronized (this) {
            if (command.equals(CONTROL.PAUSE))
                notifyAll();

            command = CONTROL.NEXT;
        }
    }

    public void previousMusic() {
        synchronized (this) {
            if (command.equals(CONTROL.PAUSE)) {
                notifyAll();
            } else if (command.equals(CONTROL.STOP)) {

            }
            command = CONTROL.PREVIOUS;
        }
    }


    private void prepareMusic() throws IOException, JavaLayerException {
        // phase 1: find music
        findMusic();

        // find number of frames
        buffer = new BufferedInputStream(new FileInputStream(presentMusic.getMediaFile()));
        player = new MachinePlayer(buffer);

        numberOfFrame = player.findNumbersOfFrame();

        player.close(); // close player and buffer

        // prepare for playing
        buffer = new BufferedInputStream(new FileInputStream(presentMusic.getMediaFile()));
        player = new MachinePlayer(buffer);

    }

    private void findMusic() {

        switch (repetitionState) {
            case ALWAYS:
                presentMusic = super.getMusics().get(indexOfMusic);
                if ( indexOfMusic < super.getMusics().size() ) {
                    indexOfMusic++;
                } else {
                    indexOfMusic = 0;
                }
                break;
            case ONECE:
                // it never happen for findMusic()
                break;
            case JUSTTHIS:
                // it doesn't do anything because the present music have to play
                break;
                default:

        }
    }

}



