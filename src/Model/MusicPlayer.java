package Model;

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

    public  void playMusic() {

    }
}
