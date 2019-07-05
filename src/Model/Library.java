package Model;

import java.io.Serializable;
import java.util.ArrayList;

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
        return Artist.getArtists();
    }

    public ArrayList<Album> getAlbums() {
        ArrayList<Album> albums = new ArrayList<>();
        for (Artist artist :
                getArtists()) {
            albums.addAll(artist.getAlbums());
        }
        return albums;
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
}
