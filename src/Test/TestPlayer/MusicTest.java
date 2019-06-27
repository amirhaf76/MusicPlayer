package Test.TestPlayer;

import static org.junit.jupiter.api.Assertions.*;

import Model.Album;
import Model.Artist;
import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import org.junit.jupiter.api.*;
import java.io.*;
import java.sql.Time;


class MusicTest {

    private static Music music;
    private static Artist artist;
    private static Album album;

    @BeforeAll
    static void setUp() {

        String parent = "I:\\Amir.haf76's Files\\Univercity\\" +
                "ProjectOfJava\\src\\Test\\FileOfTest\\";

        File file = new File(parent + "Sham Pain - Five Finger Death Punch.mp3");
        Time time = new Time(System.currentTimeMillis());

        artist = new Artist("Five Finger Death Punch");
        album = new Album("Sham Pain - Single",artist);


        try {
            music = new Music(file, time);
        } catch (UnsupportedTagException | IOException | InvalidDataException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getDetails() {
        assertEquals("Sham Pain", music.getTitle());
        assertEquals(artist, music.getArtist());
        assertEquals(album, music.getAlbum());
        assertEquals("2018", music.getYear());
        assertEquals("sham pain music", music.getComment());
        assertEquals(20, music.getGenre());
        assertEquals("22", music.getTrack());


    }

}