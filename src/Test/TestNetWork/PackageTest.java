package Test.TestNetWork;

import Model.Music;
import Model.enumeration.Command;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import network.Package;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PackageTest {
    private Package aPackage;
    private ArrayList<Music> musics = new ArrayList<>();
    private ArrayList<Command> request = new ArrayList<>();
    private byte[] bytes = new byte[]{8,9,4,6,7};
    private String path = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";


    void setUp() throws InvalidDataException, IOException, UnsupportedTagException {
        Music music = new Music(new File(path+"Homemade Dynamite Remix - Lorde.mp3"),
                new Time(System.currentTimeMillis()));
        musics.add(music);
        request.add(Command.STATUS);
        request.add(Command.DOWNLOAD);
        aPackage = new Package(request,musics,music,bytes,false);
    }

    @Test
    void testDetails() throws InvalidDataException, IOException, UnsupportedTagException {
        setUp();
        assertEquals(new Music(new File(path + "Homemade Dynamite Remix - Lorde.mp3")
                ,new Time(System.currentTimeMillis())), aPackage.getGetMusic());
        assertEquals(new Music(new File(path + "Homemade Dynamite Remix - Lorde.mp3")
                ,new Time(System.currentTimeMillis())), aPackage.getRequestedSharedMusic().get(0));
        assertFalse(aPackage.isEndDownload());
        assertArrayEquals(bytes, aPackage.getData());
        assertEquals(Command.DOWNLOAD, aPackage.getRequest().get(1) );
        assertEquals(Command.STATUS, aPackage.getRequest().get(0) );
        assertEquals(2, aPackage.getRequest().size());
        assertEquals(1, aPackage.getRequestedSharedMusic().size());
    }
}