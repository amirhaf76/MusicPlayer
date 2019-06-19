import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {

            Music music = new Music(new File("Sham Pain - Five Finger Death Punch.mp3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("helloArt".substring(1,5));

    }
}
