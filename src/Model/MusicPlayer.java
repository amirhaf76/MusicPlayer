package Model;

import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MusicPlayer {

    private ArrayList<Music> musics = new ArrayList<>();


    public void addMusic(Media media) {

        if ( media instanceof Music ) { // if media is Music, ...
            if ( !musics.contains(media) ) { // if there is not any music like media, ...
                musics.add((Music) media);
            }
        }
    }

    public void addMusic(ArrayList<Media> medium) {

        for (Media m : // for all medium
                medium) {
            this.addMusic(m);
        }

    }

    public static void playMusic(File file) throws JavaLayerException, IOException, InterruptedException, UnsupportedAudioFileException {

        System.out.println("here");
        MusicController p = new MusicController(file);
        p.startMusic(95000);
        System.out.println("here2");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("here3");

//        System.out.println(p.getPosition());

        System.out.println("here4");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("here5");
//        System.out.println(p.getPosition());
        System.out.println("here6");
    }
}
