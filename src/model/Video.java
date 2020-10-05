package model;

import model.Media;

import java.io.File;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;


public class Video extends Media implements Serializable {

    public Video(File mediaFile, LocalDateTime time) {
        super(mediaFile, time);
    }
}
