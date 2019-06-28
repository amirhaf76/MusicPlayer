package Model;

import java.util.ArrayList;

public class MusicPlayer {

    private ArrayList<Music> musics = new ArrayList<>();

    private final Object lock = new Object();

    // TODO: 6/24/2019 add lock to for adding and removing music
    public void addMusic(Media media) {

        if ( media instanceof Music ) { // if media is Music, ...

            if ( !musics.contains(media) ) { // if there is not any music like media, ...
                musics.add((Music) media);
            }
        }
    }

    public Object getLock() {
        return lock;
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
