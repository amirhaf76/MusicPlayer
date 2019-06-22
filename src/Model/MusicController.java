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
    private boolean shuffle = false;
    private int indexOfMusic;
    private ArrayList<Music> pastMusic = new ArrayList<>();

    
    // player
    private MachinePlayer player;

    // frames and time
    private long numberOfFrame;
    private int lastTime = 0;


    private final Object lock = new Object(); // make player lock

    private CONTROL command;
    



    public MusicController() throws IOException, JavaLayerException {
        command = NOTSTARTED;
        start();
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
                                    lastTime = player.getPosition();
                                    wait();
                                    break;

                                case NEXT:
                                    player.close();
                                    notifyAll();
                                    break;
                                case PREVIOUS:
                                    player.close();
                                    notifyAll();
                                    break;
                                case STOP:
                                    player.close();
                                    break;
                                case FIINISH:
                                    player.close();
                                default:
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

        if ( command.equals(FIINISH) ) {
            prepareMusic(presentMusic);
            start();
        }

    }


    public void start() throws IOException, JavaLayerException {
        synchronized (this) {
            switch (command) {
                case FIINISH:
                    if ( repetitionState.equals(JUSTTHIS) ) {
                        command = PLAYING;
                        prepareMusic(presentMusic);
                        playMusic();
                        break;
                    }
                case NOTSTARTED:
                    command = CONTROL.PLAYING;
                    if (shuffle) {
                        prepareMusic( nextMusicBasedOnShuffle() );
                    } else {
                        prepareMusic( nextMusicBasedOnArrangement());
                    }

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

    public void nextMusic(File musicFile) throws InterruptedException, IOException, JavaLayerException {
        synchronized (this) {
            command = NEXT;
            wait();
            prepareMusic(
                    nextMusicBasedOnMode()
            );
            command = NOTSTARTED;
            start();
        }
    }

    public void previousMusic() throws InterruptedException, IOException, JavaLayerException {
        synchronized (this) {
            command = PREVIOUS;
            wait();
            if (shuffle) {
                prepareMusic( previousMusicBasedOnShuffle() );
            } else {
                prepareMusic( previousMusicBasedOnArrangement() );
            }
            this.start();
        }
    }

    private Music nextMusicBasedOnMode() throws IOException, JavaLayerException {

        switch (repetitionState) {
            case ONECE:
                if (shuffle) {
                    if ( pastMusic.size() < super.getMusics().size() ) {
                        return nextMusicBasedOnShuffle();
                    } else {
                        command = FIINISH;
                    }
                }
                else {
                    if ( indexOfMusic < super.getMusics().size() ) {
                        return nextMusicBasedOnArrangement();
                    }
                    else {
                        command = FIINISH;
                    }
                }
                break;
            case ALWAYS:
                if (shuffle) {
                    return nextMusicBasedOnShuffle();
                } else {
                    return nextMusicBasedOnArrangement();
                }

            default:
        }
        return presentMusic; // !!!!!!!
    }




    private void prepareMusic(Music music) throws IOException, JavaLayerException { // totally
        synchronized (lock) {
            // save present music
            presentMusic = music;

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

    private Music previousMusicBasedOnShuffle() {
        Music music;
        if ( pastMusic.size() - 1 < 0 ){
            music = pastMusic.get(0);
        } else {
            music = pastMusic.get(pastMusic.size() - 1);
        }
        pastMusic.remove(music);
        return music;
    }

    private Music previousMusicBasedOnArrangement() {
        if ( indexOfMusic == 0 || indexOfMusic >= super.getMusics().size() ){
            return super.getMusics().get(super.getMusics().size() - 1);
        } else {
            indexOfMusic--;
            return super.getMusics().get(indexOfMusic);
        }
    }




    private Music nextMusicBasedOnShuffle() {
        Random random = new Random(getMusics().size());

        if ( !(pastMusic.size() < super.getMusics().size()) ) {
            pastMusic.removeAll(super.getMusics().subList(0,super.getMusics().size()));
        }
        while (true) {
            Music tempMusic = super.getMusics().get(random.nextInt());
            if ( !pastMusic.contains(tempMusic) ){
                pastMusic.add(tempMusic);
                return tempMusic;
            }
        }

    }



    private Music nextMusicBasedOnArrangement() {
        Music music;

        if ( (indexOfMusic < super.getMusics().size()) ) {
            indexOfMusic = 0;
        }

        music = super.getMusics().get(indexOfMusic);
        indexOfMusic++;
        return music;

    }

}



