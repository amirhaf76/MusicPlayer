package Model;

import java.io.File;
import java.sql.Time;

public class Media {
    private final File mediaFile;
    private Time addedTime;

    // TODO: 6/20/2019 SimpleDataFormat

    public Media(File mediaFile, Time addedTime) {
        this.mediaFile = mediaFile;
        this.addedTime = addedTime;
    }

    public File getMediaFile() {
        return mediaFile;
    }

    public Time getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Time addedTime) {
        this.addedTime = addedTime;
    }


}
