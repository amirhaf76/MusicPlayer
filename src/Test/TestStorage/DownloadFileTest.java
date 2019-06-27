package Test.TestStorage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.DownloadFile;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DownloadFileTest {

    private static DownloadFile downloadFile;
    private static String parent;




    void setUp() throws FileNotFoundException {
        parent = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";
        downloadFile = new DownloadFile(new File(parent + "Natural - Imagine Dragons.mp3"));

    }

    @Test
    void prepareForSending() throws IOException {
        setUp();
        RandomAccessFile fos = new RandomAccessFile(parent + "TestPrepare"+".mp3", "rw");
        assertFalse(downloadFile.isReady());
        downloadFile.prepareForSending();
        assertTrue(downloadFile.isReady());

        while (!downloadFile.isEnd()) {
            byte[] bytes = downloadFile.getPartOfData();
            fos.write(bytes);
        }
        fos.close();

        assertEquals(0, downloadFile.getPartOfData().length);
        assertEquals(0, downloadFile.getPartOfData().length);
        assertTrue(downloadFile.isEnd());
    }


}