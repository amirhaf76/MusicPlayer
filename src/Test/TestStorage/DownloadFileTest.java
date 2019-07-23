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

    static {
        parent = "I:" + File.separator +
                "Amir.haf76's Files" + File.separator +
                "Univercity" + File.separator +
                "Advance programming" + File.separator +
                "Final Project of Java" + File.separator +
                "src" + File.separator +
                "Test" + File.separator +
                "FileOfTest" + File.separator;
        downloadFile = new DownloadFile(new File(parent + "Natural - Imagine Dragons.mp3"));
    }


    @Test
    void prepareForSending() throws IOException {
        File file = new File(parent + "TestPrepare"+".mp3");
        File file1 = new File("TestPrepare"+".mp3");
        file.getParentFile().mkdir();
        file.createNewFile();

        RandomAccessFile fos = new RandomAccessFile(file, "rws");
        assertFalse(downloadFile.isReady());
        downloadFile.prepareForSending();
        assertTrue(downloadFile.isReady());

        while (!downloadFile.isEnd()) {
            byte[] bytes = downloadFile.getPartOfData();
            fos.write(bytes);
        }
        fos.close();

        assertTrue(downloadFile.isEnd());
    }


}