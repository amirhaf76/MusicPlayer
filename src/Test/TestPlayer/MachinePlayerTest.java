package Test.TestPlayer;

import Model.MachinePlayer;
import Model.Music;
import Model.MusicController;
import javazoom.jl.decoder.JavaLayerException;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("Duplicates")
class MachinePlayerTest {

    private static BufferedInputStream buffer;
    private static MachinePlayer player;
    private static String parent  = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";

    @BeforeEach
    void setUp() throws IOException, JavaLayerException {

        buffer = new BufferedInputStream(new FileInputStream(parent + "Sham Pain - Five Finger Death Punch.mp3"));
        player = new MachinePlayer(buffer);


    }

    @Test
    void skipMusic() throws JavaLayerException, IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start");


        player.close();
        buffer = new BufferedInputStream(new FileInputStream(parent + "Sham Pain - Five Finger Death Punch.mp3"));
        player = new MachinePlayer(buffer);
        System.out.println("ready");

        player.skipMusicBasedOnFrame(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("skip()");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}