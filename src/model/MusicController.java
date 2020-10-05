package model;

import javazoom.jl.decoder.JavaLayerException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static javax.swing.JOptionPane.*;

public class MusicController {

    private MusicList musicList = new MusicList();

    private MachinePlayer currentPlayer;



    public void play() {
        currentPlayer.play();
    }

    public void pause() {
        currentPlayer.pause();
    }

    public void stop() {
        currentPlayer.stop();
    }

    public void selectMusic(Music music) {
        if (currentPlayer != null)
            currentPlayer.close();

        currentPlayer = prepareMusic(music);

        if (currentPlayer != null)
            currentPlayer.runMusic();

    }

    public void next() {
        if (currentPlayer != null)
            currentPlayer.close();

        currentPlayer = prepareMusic(musicList.nextMusic());

        if (currentPlayer != null)
            currentPlayer.runMusic();

    }

    public void previous() {
        if (currentPlayer != null)
            currentPlayer.close();

        currentPlayer = prepareMusic(musicList.previousMusic());

        if (currentPlayer != null)
            currentPlayer.runMusic();

    }

    public void setShaffel() {}

    public void setRepetition() {}

    public MusicList getMusicList() {
        return musicList;
    }

    private MachinePlayer prepareMusic(Music music) {
        MachinePlayer mp;

        try {
            mp = new MachinePlayer(new FileInputStream(music.getFile()));
            return mp;
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            showMessageDialog(null,
                    "The file of music is not available !",
                    "Error",
                    ERROR_MESSAGE
            );
        }
        return null;
    }

    private void shaffelMusics() {musicList.shuffleMusics();}

    private void alphabeticalMusics() {musicList.alphabeticalSortMusics();}


    public void addMusic(Music music) {
        this.musicList.addMusic(music);
    }
}
