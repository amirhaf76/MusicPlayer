import Model.Music;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        File file = new File("Sham Pain - Five Finger Death Punch.mp3");
//        Music music = new Music(file);
//        try {
//
//            music.getArtWork();
//        } catch (UnsupportedTagException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidDataException e) {
//            e.printStackTrace();
//        }

        ReadArtWork readArtWork = new ReadArtWork();
        try {

            Mp3File mp3File = new Mp3File("Sham Pain - Five Finger Death Punch.mp3");
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }
}
