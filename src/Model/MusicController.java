package Model;

import Model.enumeration.Control;
import Model.enumeration.Repetition;
import javazoom.jl.decoder.JavaLayerException;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static Model.enumeration.Control.*;
import static Model.enumeration.Repetition.*;

public class MusicController extends MusicPlayer implements Serializable {

    // file
    private Music presentMusic;
    private static final long serialVersionUID = 1398869L;

    // playing mode
    private int indexOfShuffleMusic = 1;
    private Repetition repetitionState = ONCE;
    private boolean shuffle = false;
    private int indexOfMusic = 0;
    private ArrayList<Music> pastMusic = new ArrayList<>();

    // player
    private MachinePlayer player;


    // frames and time
    private volatile int lastFrame = 0;

    // controlling
    private final Object lock = super.getLock(); // make player lock
    private Control command;

    public int getLastFrame() {
        synchronized (lock) {
            return lastFrame;
        }
    }

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

                } catch (JavaLayerException | InterruptedException |
                        IOException | InvalidDataException | UnsupportedTagException e) {
                    e.printStackTrace();
                }
            }
        }, "Music player");
//        runPlayer.setDaemon(true);
        runPlayer.setPriority(Thread.MAX_PRIORITY);

        runPlayer.start(); // if song reach to the end, player shutdownManager buffer

    }


    public void start() throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
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
            command = Control.STOP;
        }
    }

    public void nextMusic() throws IOException, JavaLayerException, InterruptedException, InvalidDataException, UnsupportedTagException {
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

    public void previousMusic() throws InterruptedException, IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
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
    public void skipMusic(int percentage) throws IOException, JavaLayerException, InterruptedException, InvalidDataException, UnsupportedTagException {
        if ( percentage >= 0 && percentage <= 100) {
            if ( presentMusic != null ) {
                // calculate frame number
                int frameNumber = ((percentage * presentMusic.getFrames()) / 100);

                Control lastCommand = command;
                synchronized (lock) {

                    command = SKIP;
                    lock.wait();

                    // prepare music again
                    prepareMusic(presentMusic);

                    // skip frames
                    if ( lastFrame > frameNumber)
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
    }

    public Control getCommand() {
        return command;
    }

    public long calculateLastTime() {
        return (lastFrame * presentMusic.getTime())/ presentMusic.getFrames();
    }

    public void selectMusic(Music music, ArrayList<Media> medium) throws JavaLayerException, UnsupportedTagException, InvalidDataException, IOException, InterruptedException {

        this.stop();
        Thread.sleep(1000);

        if ( !medium.equals(super.getMusics()) ) {
            super.removeAllMusics();
            super.addMusic(medium);
        }
        for (Music m :
                super.getMusics()) {
            if ( m.equals(music) ) {
                presentMusic = m;
                System.out.println(55);
            }
        }

        this.start();
    }

    private void prepareMusic(Music music) throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException { // totally
        synchronized (lock) {
            // save present music
            presentMusic = music;

            lastFrame = 0;

            BufferedInputStream buffer = new BufferedInputStream(
                    new FileInputStream(presentMusic.getMediaFile()));
            player = new MachinePlayer(buffer);
        }

    }

    private Music nextMusicBasedOnMode() {

        switch (repetitionState) {
            case ONCE:
//                System.out.println("once");
                if (shuffle) {
                    if ( pastMusic.size() < super.getMusics().size() ) {
                        return nextMusicBasedOnShuffle();
                    } else {
                        command = FINISH;
                    }
                }
                else {
                    // when player go next music in nextMusicBasedOnArrangement
                    // in last music indexOfMusic equals with once more than
                    // size of musics in list of MusicPlayer
                    if ( indexOfMusic < super.getMusics().size() ) {
//                        System.out.println("once next");
                        return nextMusicBasedOnArrangement();
                    }
                    else {
//                        System.out.println("once: end");
                        command = FINISH;
                    }
                }
                break;
            case ALWAYS:
//                System.out.println("always");
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


    private Music nextMusicBasedOnShuffle() {
        Random random = new Random();

        if ( !(pastMusic.size() < super.getMusics().size()) ) {
            pastMusic.removeAll(super.getMusics().subList(0,super.getMusics().size()));
        }
        while (true) {
            Music tempMusic = super.getMusics().get(random.nextInt(getMusics().size())); // TODO: 6/27/2019 check random
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




}




