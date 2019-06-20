package Test;

import static org.junit.jupiter.api.Assertions.*;

import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import org.junit.jupiter.api.*;

import javax.imageio.ImageIO;
import java.io.*;
import java.sql.Time;
import java.util.Scanner;

class MusicTest {

    private static Music music;
    private static File file;
    private static Time time;
    private static RandomAccessFile imageFile;



    @BeforeAll
    static void setUp() {
        String parent = "I:\\Amir.haf76's Files\\Univercity\\" +
                "ProjectOfJava\\src\\Test\\FileOfTest\\";

        file =  new File(parent + "Sham Pain - Five Finger Death Punch.mp3");
        time = new Time(System.currentTimeMillis());


        try {

            imageFile = new RandomAccessFile(parent + "Sham Pain.jpg","r");

            music = new Music(file,time);
        } catch (UnsupportedTagException | IOException | InvalidDataException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getDetails() {
        assertEquals("Sham Pain", music.getTitle());
        assertEquals("Five Finger Death Punch", music.getArtist());
        assertEquals("Sham Pain - Single", music.getAlbum());
        assertEquals("2018", music.getYear());
        assertEquals("sham pain music", music.getComment());
        assertEquals(20, music.getGenre());
        assertEquals("22", music.getTrack());


    }

}