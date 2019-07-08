package Model;

import Model.enumeration.Control;
import Model.enumeration.Repetition;

import control.CMusicController;
import javazoom.jl.decoder.JavaLayerException;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import static Model.enumeration.Control.*;
import static Model.enumeration.Repetition.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("Duplicates")
public class MusicController implements Serializable {

    // file
    private Music presentMusic;
    private static final long serialVersionUID = 1398869L;

    private JSlider slider;
    private CMusicController cMusicController;

    // playing mode
    private Repetition repetitionState = ONCE;
    private boolean shuffle = false;
    private int indexOfMusic = 0;
    private MusicList musicList = new MusicList();
    private ListIterator<Music> musicListIterator = musicList.getMusics().listIterator();
    private ArrayList<Music> pastMusic = new ArrayList<>();

    // frames and time
    private int lastFrame = 0;

    // controlling
    private final Object lock = musicList.getLock(); // make player lock
    private Control command = STOP;
    private Thread runPlayer;


    public MusicList getMusicList() {
        return musicList;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public void setcMusicController(CMusicController cMusicController) {
        this.cMusicController = cMusicController;
    }

    private void play(MachinePlayer machinePlayer) {

        runPlayer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (command.equals(Control.PLAYING)) {

                        if (!machinePlayer.play(1)) {
                            command = FINISH;
//                            System.out.println(command);
                            machinePlayer.close();
                            start();
                            break;
                        } else {
                            lastFrame++;

                        }

                        synchronized (lock) {

                            if (slider != null ) {
                                slider.removeChangeListener(slider.getChangeListeners()[0]);
                                if ( !slider.getValueIsAdjusting() ){
                                    slider.setValue(getPosition());
                                }
                                slider.addChangeListener(cMusicController.skipSlider());
                            }
                            switch (command) {
                                case PAUSE:
//                                    System.out.println(command);
                                    lock.wait();
                                    break;

                                case SKIP:
//                                    System.out.println(command);
                                    machinePlayer.close();
                                    lock.notify();
                                    break;

                                case NEXT:
//                                    System.out.println(command);
                                    machinePlayer.close();
                                    lock.notify();
                                    break;
                                case PREVIOUS:
//                                    System.out.println(command);
                                    machinePlayer.close();
                                    lock.notify();
                                    break;
                                case STOP:
//                                    System.out.println(command);
                                    machinePlayer.close();
                                    break;
                                case FINISH:
//                                    System.out.println(command);
                                    machinePlayer.close();
                                    break;
                                case SELECTMUSIC:
                                    machinePlayer.close();
                                    lock.notify();
                                default:
//                                    System.out.println(command);
                            }

                        }
                    }


                } catch (JavaLayerException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Music player");

        runPlayer.setPriority(Thread.MAX_PRIORITY);

        runPlayer.start(); // if song reach to the end, player shutdownManager buffer

    }


    public void start()  {
        synchronized (lock) {
            switch (command) {
                case PAUSE:
                    command = PLAYING;
                    lock.notifyAll();
                    break;

                case STOP:
                    command = PLAYING;
                    if ( presentMusic == null ) {
                        play( prepareMusic(musicList.getMusics().get(0)) );
                    } else {
                        play( prepareMusic(presentMusic) );
                    }

                    break;

                case FINISH:

                    command = PLAYING;

                    // next music base on mode
                    play( prepareMusic(nextMusicBasedOnMode() ));

                    break;

            }
        }
    }

    public void pause() {
        synchronized (lock) {
            command = PAUSE;
        }
    }


    public void stop() {
        synchronized (lock) {
            command = STOP;
        }
    }

    public void nextMusic() {
        // if status was Pause
        synchronized (lock) {

            if ( command.equals(PAUSE) )
                runPlayer.stop();
            else if (command.equals(PLAYING)) {

                command = NEXT;

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                command = PLAYING;
            play( prepareMusic(nextMusicBasedOnMode()) );
        }
    }

    public void previousMusic() {
        synchronized (lock) {

            if ( command.equals(PAUSE) )
                runPlayer.stop();
            else if (command.equals(PLAYING)) {

                command = PREVIOUS;

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            command = PLAYING;

            if (shuffle) {
                play( prepareMusic( previousMusicBasedOnShuffle() ) );
            } else {
                play( prepareMusic( previousMusicBasedOnArrangement() ) );
            }

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

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public Repetition getRepetitionState() {
        return repetitionState;
    }

    public int getPosition() {
        return 100 * lastFrame/presentMusic.getFrames();
    }

    // based on percentage
    public void skipMusic(int percentage)  {
        if ( percentage >= 0 && percentage <= 100) {

            if ( presentMusic != null ) {
                // calculate frame number

                int frame = ((presentMusic.getFrames() * percentage) / 100);
                synchronized (lock) {

                    if ( command.equals(PAUSE) ) {
                        runPlayer.stop();
                    }
                    else if (command.equals(PLAYING) ) {
                        command = SKIP;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                    // prepare music again
                    MachinePlayer mp = prepareMusic(presentMusic);

                    if ( mp != null ) {
                        System.out.println(frame);
                        lastFrame = frame;
                        mp.skipMusicBasedOnFrame(frame);
                        command = PLAYING;
                        play(mp);
                    }


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

    public void selectMusic(Music music) {
        if ( musicList.getMusics().contains(music) ) {
            synchronized (lock) {
                command = SELECTMUSIC;

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                presentMusic = musicList.getMusics().get(
                        musicList.getMusics().indexOf(music) );

                play( prepareMusic(presentMusic) );

            }

        }
    }

    private MachinePlayer prepareMusic(Music music){ // totally
        synchronized (lock) {

            // keep current music
            presentMusic = music;

            // prepare frame number
            lastFrame = 0;

            try {
                BufferedInputStream buffer = new BufferedInputStream(
                        new FileInputStream(presentMusic.getFile()));

                return new MachinePlayer(buffer);

            } catch (FileNotFoundException e) {
                showMessageDialog(null, "There is not this file",
                        "Error", ERROR_MESSAGE);
            } catch (JavaLayerException e) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Error in playing","Error",JOptionPane.ERROR_MESSAGE);
            }
        }

        return null;
    }

    private Music nextMusicBasedOnMode() {

        switch (repetitionState) {
            case ONCE:
                if (shuffle)
                    if ( pastMusic.equals(musicList.getMusics()) ) {
                        command = FINISH;
                        break;
                    }
                else
                    if ( indexOfMusic != 0) {
                        command = FINISH;
                        break;
                    }

                    // continue

            case ALWAYS:
                if (shuffle)
                    return nextMusicBasedOnShuffle();
                else
                    return nextMusicBasedOnArrangement();
            default:

        }
        return musicList.getMusics().get(0); // !!!!!
    }


    private Music nextMusicBasedOnShuffle() {
        Random random = new Random();

        if ( pastMusic.equals(musicList.getMusics()) )
            pastMusic.removeAll(musicList.getMusics());

        while (true) {
            Music tempMusic = musicList.getMusics()
                    .get(random.nextInt(musicList.getMusics().size() - 1)); // TODO: 6/27/2019 check random

            if ( !pastMusic.contains(tempMusic) ){
                pastMusic.add(tempMusic);
                return tempMusic;
            }
        }

    }



    private Music nextMusicBasedOnArrangement() {
        Music music;

        if ( indexOfMusic + 1 == musicList.getMusics().size())
            indexOfMusic = 0;
        else
            indexOfMusic++;

        music = musicList.getMusics().get(indexOfMusic);

        return music;
    }



    private Music previousMusicBasedOnShuffle() {
        Music music;
        if ( pastMusic.isEmpty() ){
            music = presentMusic;
        } else {
            music = pastMusic.get(pastMusic.size()-1);
        }
        pastMusic.remove(music);
        pastMusic.trimToSize();

        return music;
    }

    private Music previousMusicBasedOnArrangement() {
        if ( indexOfMusic - 1 >= 0 ) {
            indexOfMusic--;
            return musicList.getMusics().get(indexOfMusic);
        } else {
            indexOfMusic = musicList.getMusics().size()-1;
            return musicList.getMusics().get(indexOfMusic);
        }

    }



}




