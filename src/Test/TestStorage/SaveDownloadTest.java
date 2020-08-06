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

    private static SaveDownload saveDownload;
    private static DownloadFile downloadFile;
    private static String parent;
    private static String nameFile;

    static {
        parent = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";
        nameFile = "Homemade Dynamite Remix - Lorde.mp3";
        downloadFile = new DownloadFile(new File(parent + nameFile));
        saveDownload = new SaveDownload("amirhosein", nameFile);

        downloadFile.prepareForSending();
    }


    @Test
    void saveData() {

        assertFalse(saveDownload.isEnd());
        while ( !downloadFile.isEnd() ) {

            try {
                saveDownload.saveData(downloadFile.getPartOfData());
            } catch (IOException e) {
                System.out.println("Error");
                break;
            }
        }
        saveDownload.end();
        assertTrue(saveDownload.isEnd());

    }
}