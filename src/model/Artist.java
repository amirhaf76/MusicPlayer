package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Artist implements Serializable {

    /**
     * identification of each Artist
     */
    private final String name;
    private final ArrayList<Album> albums = new ArrayList<>();

    // serialization
    private static final long serialVersionUID = 1398444L;

    public Artist(String name) {
        this.name = name;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    private Iterator<Music> getAllMusic() {
        ArrayList<Music> temp = new ArrayList<>();
        for (Album alm :
                albums) {
            temp.addAll(alm.getMusics());
        }
        return temp.iterator();
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
