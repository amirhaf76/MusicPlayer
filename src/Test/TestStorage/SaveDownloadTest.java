package Test.TestStorage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.DownloadFile;
import storage.SaveDownload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SaveDownloadTest {

    private SaveDownload saveDownload;
    private DownloadFile downloadFile;
    private String parent;
    private String nameFile;

    void setUp() throws IOException {
        parent = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";
        nameFile = "Homemade Dynamite Remix - Lorde.mp3";
        downloadFile = new DownloadFile(new File(parent + nameFile));
        saveDownload = new SaveDownload("amirhosein", nameFile);

        downloadFile.prepareForSending();

    }

    @Test
    void saveData() throws IOException {
        setUp();
        assertFalse(saveDownload.isEnd());
        while ( !downloadFile.isEnd() ) {
            saveDownload.saveData(downloadFile.getPartOfData());
        }
        saveDownload.end();
        assertTrue(saveDownload.isEnd());

    }
}