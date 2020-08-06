package Test.TestPlayer;

import model.Music;
import model.MusicController;
import javazoom.jl.decoder.JavaLayerException;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("Duplicates")
class MusicControllerTest {

    private static Music music1;
    private static Music music2;
    private static Music music3;
    private static Music music4;
    private static MusicController musicController;

    static void setUp() throws InvalidDataException, IOException, UnsupportedTagException {
        String parent  = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";
        musicController = new MusicController();

        music2 = new Music(new File(parent + "Hymn For The Weekend - Coldplay.mp3"),
                new Time(System.currentTimeMillis()));
        music1 = new Music(new File(parent + "Sham Pain - Five Finger Death Punch.mp3"),
                new Time(System.currentTimeMillis()));
        music3 = new Music(new File(parent + "Natural - Imagine Dragons.mp3"),
                new Time(System.currentTimeMillis()));
        music4 = new Music(new File(parent + "Homemade Dynamite Remix - Lorde.mp3"),
                new Time(System.currentTimeMillis()));


        musicController.addMusic(music1);
        musicController.addMusic(music2);
        musicController.addMusic(music3);
        musicController.addMusic(music4);

    }

    @Test
    void addMusic() throws InvalidDataException, IOException, UnsupportedTagException {
        setUp();
        assertTrue(musicController.getMusics().contains(music1));
        assertTrue(musicController.getMusics().contains(music2));
        assertTrue(musicController.getMusics().contains(music3));
        assertTrue(musicController.getMusics().contains(music4));
    }


    @Test
    void testPlaying() throws IOException, JavaLayerException, InterruptedException, InvalidDataException, UnsupportedTagException {
        setUp();
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

    @Test
    void justThis() throws IOException, JavaLayerException, InterruptedException, InvalidDataException, UnsupportedTagException {
        setUp();
        musicController.justThis();
        musicController.start();

        Thread.sleep(5000);

        musicController.skipMusic(90);
        System.out.println("please wait for 1 minutes");
        Thread.sleep(60000);
        System.out.println("done");

    }

    @Test
    void nextMusic() throws InvalidDataException, IOException, UnsupportedTagException, JavaLayerException, InterruptedException {
        setUp();
        musicController.repeatAlways();
        musicController.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("nextMusic");
        musicController.nextMusic();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("nextMusic");
        musicController.nextMusic();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("nextMusic");
        musicController.nextMusic();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("nextMusic");
        musicController.nextMusic();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    void once() throws InvalidDataException, IOException, UnsupportedTagException, JavaLayerException, InterruptedException {
        setUp();
        musicController.repeatOnce();
        musicController.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("nextMusic");
        musicController.nextMusic();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("nextMusic");
        musicController.nextMusic();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("nextMusic");
        musicController.nextMusic();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        musicController.skipMusic(90);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}