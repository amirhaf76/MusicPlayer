package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Artist implements Serializable {

    private final String name;
    private final ArrayList<Album> albums = new ArrayList<>();
    private final Album singleSongs = new Album("SingleSongs", this);

    private static final long serialVersionUID = 1398444L;

    public Artist(String name) {
        this.name = name;

    }

    public void addAlbum(Album album) {
        if ( name.equals(album.getArtist().getName()) ) {
            albums.add(album);
        }
    }

    public void addMusic(Music music) {
        if ( albums.contains(music.getAlbum()) ) {
            for (Album a: albums) {
                if ( a.equals(music.getAlbum()) ){
                    a.addMusic(music);
                }
            }
        } else {
            singleSongs.addMusic(music);
        }
    }

    public String getName() {
        return name;
    }

    public Album getSingleSongs() {
        return singleSongs;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    private ArrayList<Music> getMusic() {
        ArrayList<Music> music = new ArrayList<>();
        for (Album a :
                albums) {
            music.addAll(a.getMusics());
        }
        return music;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return name.equals(artist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Artist : " + name;
    }
}
