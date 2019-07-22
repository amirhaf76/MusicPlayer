package Test.TestPlayer;

import static org.junit.jupiter.api.Assertions.*;

import Model.Album;
import Model.Artist;
import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;
import org.junit.jupiter.api.*;
import java.io.*;
import java.sql.Time;
import java.time.LocalDateTime;


class MusicTest {

    private static Music music1;
    private static Music music2;
    private static Music music3;
    private static Music music4;

    private static String parent = "I:\\Amir.haf76's Files\\Univercity\\Advance programming\\" +
            "Final Project of Java\\src\\Test\\FileOfTest\\";


    static {
        music1 = new Music(new File(parent + "Natural - Imagine Dragons.mp3"),
                LocalDateTime.now());
        music2 = new Music(new File( parent + "Sham Pain - Five Finger Death Punch.mp3"),
                LocalDateTime.now());
        music3 = new Music(new File(parent + "Homemade Dynamite Remix - Lorde.mp3"),
                LocalDateTime.now());
        music4 = new Music(new File(parent + "40662.mp3"),
                LocalDateTime.now());
    }

    @Test
    void testArtists() {
        assertTrue(Artist.getArtists().contains(new Artist("Imagine Dragons")));
        assertTrue(Artist.getArtists().contains(new Artist("Five Finger Death Punch")));
        assertTrue(Artist.getArtists().contains(new Artist("Lorde")));
        assertFalse(Artist.getArtists().contains(new Artist("50cent")));

        music3.remove();
        assertFalse(Artist.getArtists().contains(new Artist("Lorde")));
        System.out.println("Test of Artist is completed.");

//        for ( Artist a: Artist.getArtists())
//            System.out.println(a);
    }


}