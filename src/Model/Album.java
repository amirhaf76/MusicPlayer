package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {
    private final String name;
    private final Artist artist;
    private ArrayList<Music> musics = new ArrayList<>();

    private static final long serialVersionUID = 1398443L;

    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }

    public void addMusic(Music music) {
        if ( music.getArtist().equals(artist) ) {
            this.musics.add(music);
        }
    }
    public void removeMusic(Music music) {
        if ( music.getArtist().equals(artist) ) {
            this.musics.remove(music);
        }
    }
}
