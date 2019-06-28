import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import storage.*;

import java.awt.*;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Time;

public class Main {
    public static void main(String[] args) throws IOException, InvalidDataException, UnsupportedTagException {
        String path = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";
        Music music = new Music(new File(path +"Natural - Imagine Dragons.mp3"), new Time(System.currentTimeMillis()));
        MakeImage makeImage = new MakeImage(music);
    }
}
