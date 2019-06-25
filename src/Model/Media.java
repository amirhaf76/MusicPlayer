package Model;

import java.io.File;
import java.io.Serializable;
import java.sql.Time;

public class Media implements Serializable {
    private final File mediaFile;
    private Time addedTime;
    private Time lastTime; // TODO: 6/25/2019 add to music player

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

    public Time getLastTime() {
        return lastTime;
    }

    public void setLastTime(Time lastTime) {
        this.lastTime = lastTime;
    }
}
