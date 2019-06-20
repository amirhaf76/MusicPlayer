package Test;

import static org.junit.jupiter.api.Assertions.*;

import Model.Media;
import org.junit.jupiter.api.*;
import java.io.File;
import java.sql.Time;

class MediaTest {

    private static Media media;
    private static Time time;

    @BeforeAll
    static void setUp() {

        File file = new File("I:\\Amir.haf76's Files\\Univercity\\" +
                "ProjectOfJava\\src\\Test\\FileOfTest\\Sham Pain - Five Finger Death Punch.mp3");
        time = new Time(System.currentTimeMillis());
        media = new Media(file,
                new Time(System.currentTimeMillis()));

    }

    @Test
    @DisplayName("getMediaFile")
    void getMediaFile() {

        assertNotNull(media.getMediaFile());
        assertEquals("I:\\Amir.haf76's Files\\Univercity\\" +
        "ProjectOfJava\\src\\Test\\FileOfTest\\Sham Pain - Five Finger Death Punch.mp3",
                media.getMediaFile().getAbsolutePath() );
        assertEquals("I:\\Amir.haf76's Files\\Univercity\\" +
        "ProjectOfJava\\src\\Test\\FileOfTest",
                media.getMediaFile().getParent() );
        assertEquals("Sham Pain - Five Finger Death Punch.mp3",
                media.getMediaFile().getName() );

    }

    @Test
    @DisplayName("setTime")
    void setTime() {
        time = new Time(System.currentTimeMillis());
        media.setTime(time);
        assertEquals(time, media.getTime());
    }

    @Test
    @DisplayName("getTime")
    void getTime() {
        assertEquals(time, media.getTime());
    }
}