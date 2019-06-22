package Model;

import javazoom.jl.decoder.JavaLayerException;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static Model.CONTROL.*;

public class MusicController extends MusicPlayer {

    // file
    private Music presentMusic;
    private BufferedInputStream buffer;

    // playing mode
    private static int indexOfShuffleMusic = 1;
    private CONTROL repetitionState = ONECE;
    private boolean shuffle = false;
    private int indexOfMusic = 0;
    private ArrayList<Music> pastMusic = new ArrayList<>();

    
    // player
    private MachinePlayer player;

    // frames and time
    private long numberOfFrame;
    private long totoalTime;
    private int lastTime = 0;


    private final Object lock = new Object(); // make player lock

    private CONTROL command;
    



    public MusicController() {
        command = NOTSTARTED;
    }


    private void playMusic() throws IOException, JavaLayerException {

        Thread runPlayer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (command.equals(CONTROL.PLAYING)) {

                        if (!player.play(1)) {
                            command = FIINISH;
                            break; // finish music
                        } else {

                            numberOfFrame++;
                        }

                        synchronized (lock) {

                            switch (command) {
                                case PAUSE:
                                    System.out.println(command);
                                    lastTime = player.getPosition();
                                    lock.wait();
                                    break;

                                case NEXT:
                                    System.out.println(command);
                                    player.close();

                                    lock.notify();
                                    break;
                                case PREVIOUS:
                                    System.out.println(command);
                                    player.close();
                                    lock.notifyAll();
                                    break;
                                case STOP:
                                    System.out.println(command);
                                    player.close();
                                    break;
                                case FIINISH:
                                    System.out.println(command);
                                    player.close();
                                default:
                                    System.out.println(command);
                            }

                        }
                    }

                } catch (JavaLayerException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Music player");
//        runPlayer.setDaemon(true);
        runPlayer.setPriority(Thread.MAX_PRIORITY);


        runPlayer.start(); // if song reach to the end, player close buffer


        if ( command.equals(FIINISH) ) {
            System.out.println("noooooooooooooooootiiiiiiiiiiiiiiiiiiiiiiiiiiic");
            prepareMusic(presentMusic);
            start();
        }

    }


    public void start() throws IOException, JavaLayerException {
        synchronized (lock) {
            switch (command) {
                case PAUSE:
                    command = PLAYING;
                    lock.notifyAll();
                    break;
                case STOP:
                    command = PLAYING;
                    prepareMusic(presentMusic);
                    playMusic();
                    break;

                case FIINISH:
                case NOTSTARTED:

                    command = PLAYING;

                    if ( repetitionState.equals(JUSTTHIS) ) {
                        prepareMusic(presentMusic);
                        playMusic();
                        break;
                    }

                    if (shuffle) {
                        prepareMusic( nextMusicBasedOnShuffle() );
                    } else {
                        prepareMusic( nextMusicBasedOnArrangement());
                    }
                    playMusic();
                    break;

            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if ( command.equals(PLAYING) ) {
                command = PAUSE;
            }
        }
    }


    public void stop() {
        synchronized (lock) {
            if (command.equals(CONTROL.PLAYING) ||
                    command.equals(CONTROL.PAUSE)) {
                command = CONTROL.STOP;
            }
        }
    }

    public void nextMusic() throws IOException, JavaLayerException {
        synchronized (lock) {
            command = NEXT;

            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prepareMusic(
                    nextMusicBasedOnMode()
            );

            command = PLAYING;

            playMusic();
        }
    }

    public void previousMusic() throws InterruptedException, IOException, JavaLayerException {
        synchronized (lock) {
            command = PREVIOUS;
            lock.wait();

            if (shuffle) {
                prepareMusic( previousMusicBasedOnShuffle() );
            } else {
                prepareMusic( previousMusicBasedOnArrangement() );
            }
            command = PLAYING;
            playMusic();
        }
    }

    private Music nextMusicBasedOnMode() {

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

            totoalTime = player.getPosition();
            System.out.println(numberOfFrame);
            player.close(); // close player and buffer

            // prepare for playing
            buffer = new BufferedInputStream(new FileInputStream(presentMusic.getMediaFile()));
            player = new MachinePlayer(buffer);
        }

    }

    private Music previousMusicBasedOnShuffle() {
        Music music;
        if ( pastMusic.size() == 0 ){
            music = presentMusic;
        } else {
            if ( indexOfShuffleMusic < super.getMusics().size() ) {
                music = pastMusic.get(pastMusic.size()-1 - indexOfShuffleMusic);
                indexOfShuffleMusic++;
            }
            else {
                indexOfShuffleMusic = 1;
                music = pastMusic.get(pastMusic.size()-1 - indexOfShuffleMusic);
            }
        }
        pastMusic.remove(music);
        return music;
    }

    private Music previousMusicBasedOnArrangement() {
        if ( indexOfMusic == 0 ){
            return super.getMusics().get(super.getMusics().size() - 1);
        }
        else if ( indexOfMusic >= super.getMusics().size() ){
            if ( super.getMusics().size() > 1) {
                indexOfMusic = getMusics().size() - 2;
            } else {
                indexOfMusic = 0;
            }
            return super.getMusics().get(indexOfMusic);
        }
        else {
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

        if ( !(indexOfMusic < super.getMusics().size()) ) {
            indexOfMusic = 0;
        }

        music = super.getMusics().get(indexOfMusic);
        indexOfMusic++;
        return music;

    }

    public void reapeatOnce() {
        repetitionState = ONECE;
    }
    public void reapeatAlways() {
        repetitionState = ALWAYS;
    }
    public void justThis() {
        repetitionState = JUSTTHIS;
    }

    // based on percentage
    private void calculatePart(int percentage) {

    }
//
}



