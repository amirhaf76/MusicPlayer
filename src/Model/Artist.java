package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Artist implements Serializable {

    private static ArrayList<Artist> artists = new ArrayList<>();
    public static Artist unknown = new Artist("<nothing>");

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


    public static Artist createArtist(String name) {
        Artist temp = new Artist(name);
        if ( artists.contains(temp) )
            return artists.get( artists.indexOf(temp) );
        artists.add(temp);
        return temp;
    }


    public Album createAlbum(String name) {
        Album temp = new Album(name, this);
        if ( albums.contains(temp) )
            return albums.get( albums.indexOf(temp) );
        albums.add(temp);

        return temp;
    }

    public static ArrayList<Artist> getArtists() {
        return artists;
    }

    public String getName() {
        return name;
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
