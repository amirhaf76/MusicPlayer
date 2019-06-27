package Test.TestPlayer;

import Model.Music;
import Model.MusicPlayer;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {

    private static Music music1;
    private static Music music2;
    private static ArrayList<Music> musics = new ArrayList<>();
    private static MusicPlayer musicPlayer = new MusicPlayer();
    @BeforeAll
    static void setUp() throws InvalidDataException, IOException, UnsupportedTagException {
        String parent  = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";

        music1 = new Music(new File(parent + "Hymn For The Weekend - Coldplay.mp3"),
                new Time(System.currentTimeMillis()));
        music2 = new Music(new File(parent + "Sham Pain - Five Finger Death Punch.mp3"),
                new Time(System.currentTimeMillis()));
        musics.add(music1);
        musics.add(music2);

    }

    @Test
    void addMusic() {
        assertEquals(0, musicPlayer.getMusics().size());
        musicPlayer.addMusic(music1);
        assertEquals(1,musicPlayer.getMusics().size());
        musicPlayer.addMusic(music1);
        assertEquals(1,musicPlayer.getMusics().size());
        musicPlayer.addMusic(musics);
        assertEquals(2, musicPlayer.getMusics().size());
        assertTrue(musicPlayer.getMusics().contains(music1));
        assertTrue(musicPlayer.getMusics().contains(music2));
    }
}