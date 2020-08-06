package Test.TestPlayer;

import static org.junit.jupiter.api.Assertions.*;

import model.Media;
import org.junit.jupiter.api.*;
import java.io.File;
import java.time.LocalDateTime;

class MediaTest {

    private static Media media;
    private static LocalDateTime time;

    @BeforeAll
    static void setUp() {

        File file = new File("I:\\Amir.haf76's Files\\Univercity\\" +
                "ProjectOfJava\\src\\Test\\FileOfTest\\Sham Pain - Five Finger Death Punch.mp3");
        time = LocalDateTime.now();
        media = new Media(file,
                LocalDateTime.now());

    }

    @Test
    @DisplayName("getFile")
    void getMediaFile() {

        assertNotNull(media.getFile());
        assertEquals("I:\\Amir.haf76's Files\\Univercity\\" +
        "ProjectOfJava\\src\\Test\\FileOfTest\\Sham Pain - Five Finger Death Punch.mp3",
                media.getFile().getAbsolutePath() );
        assertEquals("I:\\Amir.haf76's Files\\Univercity\\" +
        "ProjectOfJava\\src\\Test\\FileOfTest",
                media.getFile().getParent() );
        assertEquals("Sham Pain - Five Finger Death Punch.mp3",
                media.getFile().getName() );

    }

    @Test
    @DisplayName("setJoinedTime")
    void setTime() {
        time = LocalDateTime.now();
        media.setJoinedTime(time);
        assertEquals(time, media.getJoinedTime());
    }

    @Test
    @DisplayName("getJoinedTime")
    void getTime() {
        assertEquals(time, media.getJoinedTime());
    }
}