import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            File file = new File("Sham Pain - Five Finger Death Punch.mp3");
            Music music = new Music(file);
            new MakeImage(new File("album-artwork"));

        } catch (IOException | InvalidDataException | UnsupportedTagException e) {
            e.printStackTrace();
        }
//        System.out.println("helloArt".substring(1,5));

    }
}
