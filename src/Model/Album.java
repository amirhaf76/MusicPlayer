package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Album implements Serializable {
    private final String name;
    private final Artist artist;
    private final ArrayList<Music> musics = new ArrayList<>();

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
        musics.remove(music);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return name.equals(album.name) &&
                artist.equals(album.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artist);
    }

    @Override
    public String toString() {
        return  "Album : " + name;
    }
}
