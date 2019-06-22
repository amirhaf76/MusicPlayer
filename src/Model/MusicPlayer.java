package Model;

import java.util.ArrayList;

public class MusicPlayer {

    private ArrayList<Music> musics = new ArrayList<>();


    public void addMusic(Media media) {
//        System.out.println(media);
        if ( media instanceof Music ) { // if media is Music, ...
//            System.out.println(media);
            if ( !musics.contains(media) ) { // if there is not any music like media, ...
//                System.out.println(media);
                musics.add((Music) media);
            }
        }
    }

    public void addMusic(ArrayList<Music> medium) {

        for (Media m : // for all medium
                medium) {
            this.addMusic(m);
        }

    }

    public ArrayList<Music> getMusics() {
        return musics;
    }
}
