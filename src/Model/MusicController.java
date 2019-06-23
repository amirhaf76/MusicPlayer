package Model;

import javazoom.jl.decoder.JavaLayerException;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static Model.Control.*;
import static Model.Repetition.*;

public class MusicController extends MusicPlayer {

    // file
    private Music presentMusic;

    // playing mode
    private int indexOfShuffleMusic = 1;
    private Repetition repetitionState = ONCE;
    private boolean shuffle = false;
    private int indexOfMusic = 0;
    private ArrayList<Music> pastMusic = new ArrayList<>();

    // player
    private MachinePlayer player;

    // frames and time
    private int lastFrame = 0;

    // controlling
    private final Object lock = new Object(); // make player lock
    private Control command;


    // constructor
    public MusicController() {
        command = NOTSTARTED;
    }


    private void playMusic() {

        Thread runPlayer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while (command.equals(Control.PLAYING)) {

                        if (!player.play(1)) {
                            command = FINISH;
//                            System.out.println(command);
                            player.close();
                            start();
                            break;
                        } else {
                            lastFrame++;
                        }

                        synchronized (lock) {

                            switch (command) {
                                case PAUSE:
//                                    System.out.println(command);
                                    lock.wait();
                                    break;

                                case SKIP:
//                                    System.out.println(command);
                                    player.close();
                                    lock.notify();
                                    break;

                                case NEXT:
//                                    System.out.println(command);
                                    player.close();
                                    lock.notify();
                                    break;
                                case PREVIOUS:
//                                    System.out.println(command);
                                    player.close();
                                    lock.notify();
                                    break;
                                case STOP:
//                                    System.out.println(command);
                                    player.close();
                                    break;
                                case FINISH:
//                                    System.out.println(command);
                                    player.close();
                                default:
//                                    System.out.println(command);
                            }

                        }
                    }

                } catch (JavaLayerException | InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "Music player");
//        runPlayer.setDaemon(true);
        runPlayer.setPriority(Thread.MAX_PRIORITY);

        runPlayer.start(); // if song reach to the end, player close buffer

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
                    if ( presentMusic == null ) {
                        prepareMusic(super.getMusics().get(0));
                    } else {
                        prepareMusic(presentMusic);
                    }
                    playMusic();
                    break;

                case FINISH:
                case NOTSTARTED:

                    command = PLAYING;

                    // for just this mode
                    if ( repetitionState.equals(JUSTTHIS) ) {
                        if ( presentMusic == null ) {
                            prepareMusic(super.getMusics().get(0));
                        } else {
                            prepareMusic(presentMusic);
                        }
                        playMusic();
                        break;
                    }

                    // next music base on mode
                    prepareMusic(nextMusicBasedOnMode());
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
            if (command.equals(Control.PLAYING) ||
                    command.equals(Control.PAUSE)) {
                command = Control.STOP;
            }
        }
    }

    public void nextMusic() throws IOException, JavaLayerException, InterruptedException {
        synchronized (lock) {
            command = NEXT;

            lock.wait();
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
            case ONCE:
                System.out.println("once");
                if (shuffle) {
                    if ( pastMusic.size() < super.getMusics().size() ) {
                        return nextMusicBasedOnShuffle();
                    } else {
                        command = FINISH;
                    }
                }
                else {
                    if ( indexOfMusic < super.getMusics().size() ) {
                        System.out.println("once next");
                        return nextMusicBasedOnArrangement();
                    }
                    else {
                        System.out.println("once: end");
                        command = FINISH;
                    }
                }
                break;
            case ALWAYS:
                System.out.println("always");
                if (shuffle) {
                    return nextMusicBasedOnShuffle();
                } else {
                    return nextMusicBasedOnArrangement();
                }

            case JUSTTHIS:
                if ( presentMusic == null ) {
                    return super.getMusics().get(0);
                } else {
                    return presentMusic;
                }
        }
        return presentMusic; // !!!!!
    }




    private void prepareMusic(Music music) throws IOException, JavaLayerException { // totally
        synchronized (lock) {
            // save present music
            presentMusic = music;

            lastFrame = 0;


//            // find number of frames
//            buffer = new BufferedInputStream(new FileInputStream(presentMusic.getMediaFile()));
//            player = new MachinePlayer(buffer);
//
//            numberOfFrame = player.findNumbersOfFrame();
//
//            player.close(); // close player and buffer

            // prepare for playing
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(presentMusic.getMediaFile()));
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

    public void repeatOnce() {
        repetitionState = ONCE;
    }
    public void repeatAlways() {
        repetitionState = ALWAYS;
    }
    public void justThis() {
        repetitionState = JUSTTHIS;
    }

    public void shuffle() {
        shuffle = !shuffle;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public Repetition getRepetitionState() {
        return repetitionState;
    }

    // based on percentage
    public void skipMusic(int percentage) throws IOException, JavaLayerException, InterruptedException {
        if ( percentage >= 0 && percentage <= 100) {

            // calculate frame number
            int frameNumber = ((percentage * presentMusic.getFrames()) / 100);

            Control lastCommand = command;
            synchronized (lock) {

                command = SKIP;
                lock.wait();

                // prepare music again
                prepareMusic(presentMusic);

                // skip frames
                lastFrame = frameNumber;
                player.skipMusicBasedOnFrame(frameNumber);

                command = PLAYING;

                playMusic();
            }
            // mode of player
            if ( lastCommand.equals(PAUSE) ) {
                pause();
            }
        }
    }

    private long calculateLastTime() {
        return (lastFrame * presentMusic.getTime())/ presentMusic.getFrames();
    }


    private void chooseJustThis() {

    }

}




