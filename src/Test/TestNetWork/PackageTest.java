package Test.TestNetWork;

import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import network.Package;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("Duplicates")
class PackageTest {
    private Package aPackage;
    private ArrayList<Music> musics = new ArrayList<>();
    private byte[] bytes = new byte[]{8,9,4,6,7};
    private String path = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";


    void setUp() throws InvalidDataException, IOException, UnsupportedTagException {
        Music music = new Music(new File(path+"Homemade Dynamite Remix - Lorde.mp3"),
                new Time(System.currentTimeMillis()));
        musics.add(music);
        aPackage = new Package(musics,music,bytes);
    }

    @Test
    void testDetails() throws InvalidDataException, IOException, UnsupportedTagException {
        setUp();
        assertEquals(new Music(new File(path + "Homemade Dynamite Remix - Lorde.mp3")
                ,new Time(System.currentTimeMillis())), aPackage.getGetMusic());
        assertEquals(new Music(new File(path + "Homemade Dynamite Remix - Lorde.mp3")
                ,new Time(System.currentTimeMillis())), aPackage.getSharedMusic().get(0));

        assertArrayEquals(bytes, aPackage.getData());
        assertEquals(1, aPackage.getSharedMusic().size());
    }
}