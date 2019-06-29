package Model;

import java.io.File;
import java.io.Serializable;
import java.sql.Time;


public class Video extends Media implements Serializable {

    public Video(File mediaFile, Time time) {
        super(mediaFile, time);
    }
}
