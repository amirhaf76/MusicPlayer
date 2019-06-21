package Model;

import java.io.File;
import java.sql.Time;

public class Media {
    private final File mediaFile;
    private Time time;

    // TODO: 6/20/2019 SimpleDataFormat

    public Media(File mediaFile, Time time) {
        this.mediaFile = mediaFile;
        this.time = time;
    }

    public File getMediaFile() {
        return mediaFile;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


}
