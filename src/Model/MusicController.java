package Model;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.text.MutableAttributeSet;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static Model.CONTROL.*;

public class MusicController extends MusicPlayer {

    // file
    private Music presentMusic;
    private BufferedInputStream buffer;

    // playing mode
    private CONTROL repetitionState = ONECE;
    private boolean once = true;
    private boolean shuffle = false;
    private int indexOfMusic;
    private ArrayList<Music> pastMusic;

    
    // player
    private MachinePlayer player;

    // frames and time
    private long numberOfFrame;
    private int lastTime = 0;


    private final Object lock = new Object(); // make player lock

    private CONTROL command;
    



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
                        synchronized (lock) {
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
                                    case STOP:
                                        command = CONTROL.STOP;
                                        player.close();
                                        break;
                                    default:
                                }
                            }
                        }
                    }

                } catch (JavaLayerException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Music player");
        runPlayer.setDaemon(true);
        runPlayer.setPriority(Thread.MAX_PRIORITY);

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
            if (command.equals(PAUSE)) {
                notifyAll();
            } else if (command.equals(STOP)) {
            }
            command = PREVIOUS;
        }
    }

    private void preparePreviousMusic() {

    }

    private void prepareMusic() throws IOException, JavaLayerException {
        synchronized (lock) {
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

    }

    private void findMusic() {

        switch (repetitionState) {
            case ALWAYS:
                if ( shuffle ) { // shuffle == true
                    if ( pastMusic.size() == super.getMusics().size() ){ // reload
                        pastMusic.removeAll( pastMusic.subList(0, pastMusic.size()) );
                    }
                    else { // find next
                        presentMusic = findMusicBasedOnShuffle();
                    }

                }
                else { // shuffle == false
                    if ( indexOfMusic < super.getMusics().size() ) { // find next
                        presentMusic = super.getMusics().get(indexOfMusic);
                        indexOfMusic++;
                    }
                    else { // reload
                        indexOfMusic = 0;
                        presentMusic = super.getMusics().get(indexOfMusic);
                    }
                }

                break;
            case ONECE:
                if ( shuffle ) { // shuffle == true
                    if ( once ){ // do it once
                        pastMusic.removeAll( pastMusic.subList(0, pastMusic.size()) );
                        once = false;
                    } else { // continue
                        if ( pastMusic.size() <= super.getMusics().size() ){
                            presentMusic = findMusicBasedOnShuffle();
                        } else {
                            this.stopMusic();
                        }
                    }

                } else { // shuffle == false
                    if ( once ) { // do it once
                        if ( !(indexOfMusic < super.getMusics().size()) ) {
                            indexOfMusic = 0;
                            presentMusic = super.getMusics().get(indexOfMusic);
                            once = false;
                        }
                    }
                    if ( indexOfMusic < super.getMusics().size() ) {
                        presentMusic = super.getMusics().get(indexOfMusic);
                        indexOfMusic++;
                    } else {
                        this.stopMusic();
                    }

                }

                break;
            case JUSTTHIS:
                // it doesn't do anything because the present music have to play
                break;
                default:

        }
    }

    private Music findMusicBasedOnShuffle() {
        Random random = new Random(getMusics().size());

        if ( pastMusic.size() < super.getMusics().size() ) {
            while (true) {
                Music tempMusic = super.getMusics().get(random.nextInt());
                if ( !pastMusic.contains(tempMusic) ){
                    pastMusic.add(tempMusic);
                    return tempMusic;
                }
            }
        }
        return presentMusic; // !!!!!!!!!
    }


}



