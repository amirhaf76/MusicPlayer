package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Library implements Serializable {

    private List medium = new List("Library");
    private ArrayList<List> playList = new ArrayList<>();

    private static final long serialVersionUID = 139843L;

    public void addPlaylist(List list) {
        playList.add(list);
    }

    public void removePlayList(List list) {
        playList.remove(list);
    }

    public void getMedium(List medium) {
        this.medium = medium;
    }

    public void setMedium(List medium) {
        this.medium = medium;
    }

    public ArrayList<List> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<List> playList) {
        this.playList = playList;
    }

    public ArrayList<Artist> getArtists() {
        return null;
    }

    public ArrayList<Album> getAlbums() {
        return null;
    }

    public ArrayList<Music> getFavorites() {
        ArrayList<Music> favorites = new ArrayList<>();

        for (Music music :
                medium.getMusic()) {
            if (music.isFavorite())
                favorites.add(music);
        }

        return favorites;
    }


    public ArrayList<Music> getSharedMusic() {
        ArrayList<Music> sharedMusic = new ArrayList<>();

        for (Music music: medium.getMusic()) {
            if ( music.isShared() )
                sharedMusic.add(music);
        }

        return sharedMusic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return medium.equals(library.medium) &&
                playList.equals(library.playList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medium, playList);
    }
}
