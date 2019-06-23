package Test;

import Model.Music;
import Model.MusicController;
import Model.MusicPlayer;
import javazoom.jl.decoder.JavaLayerException;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("Duplicates")
class MusicControllerTest {

    private static Music music1;
    private static Music music2;
    private static MusicController musicController;
    @BeforeAll
    static void setUp() throws InvalidDataException, IOException, UnsupportedTagException {
        String parent  = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";
        musicController = new MusicController();

        music2 = new Music(new File(parent + "Hymn For The Weekend - Coldplay.mp3"),
                new Time(System.currentTimeMillis()));
        music1 = new Music(new File(parent + "Sham Pain - Five Finger Death Punch.mp3"),
                new Time(System.currentTimeMillis()));

        musicController.addMusic(music1);
        musicController.addMusic(music2);

    }

    @Test
    void addMusic() {
        assertTrue(musicController.getMusics().contains(music1));
        assertTrue(musicController.getMusics().contains(music2));
    }


    @Test
    void testPlaying() throws IOException, JavaLayerException, InterruptedException {

        System.out.println(musicController.getMusics().get(0).getFrames());
        musicController.start();
        System.out.println("start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.stop();
        System.out.println("stop");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        musicController.start();
        System.out.println("start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.pause();
        System.out.println("pause");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.start();
        System.out.println("start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.nextMusic();
        System.out.println("nextMusic");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.previousMusic();
        System.out.println("previousMusic");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.previousMusic();
        System.out.println("previousMusic");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.nextMusic();
        System.out.println("nextMusic");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.nextMusic();
        System.out.println("nextMusic");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        musicController.skipMusic(50);
        System.out.println("skipMusic");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        musicController.skipMusic(10);
        System.out.println("skipMusic");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}