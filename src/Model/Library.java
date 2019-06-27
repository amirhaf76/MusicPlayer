package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {

    private ArrayList<Media> medium = new ArrayList<>();
    private List favorites = new List("favorites");
    private List sharedList = new List("Shared List");
    private ArrayList<List> playList = new ArrayList<>();

    private static final long serialVersionUID = 139843L;

    public void addMediaToLibrary(Media media) {
        medium.add(media);
    }

    public void removeMediaFromLibrary(Media media) {
        medium.remove(media);
    }

    public void addMediaToFavorites(Media media) {
        favorites.add(media);
    }

    public void removeMediaFromFavorites(Media media) {
        favorites.remove(media);
    }

    public void addMediaToSHRAEDLIST(Media media) {
        sharedList.add(media);
    }

    public void removeMediaToSHRAEDLIST(Media media) {
        sharedList.remove(media);
    }

    public ArrayList<Artist> getArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        for (Media m :
                medium) {
            if ( m instanceof Music ) {
                artists.add(((Music) m).getArtist());
            }
        }
        return artists;
    }

    public ArrayList<Album> getAlbums() {
        ArrayList<Album> albums = new ArrayList<>();
        for (Artist artist :
                getArtists()) {
            albums.addAll(artist.getAlbums());
        }
        return albums;
    }

    public ArrayList<Media> getMedium() {
        return medium;
    }

    public void setMedium(ArrayList<Media> medium) {
        this.medium = medium;
    }

    public ArrayList<List> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<List> playList) {
        this.playList = playList;
    }

    public List getFavorites() {
        return favorites;
    }

    public void setFavorites(List favorites) {
        this.favorites = favorites;
    }

    public List getSharedList() {
        return sharedList;
    }

    public void setSharedList(List sharedList) {
        this.sharedList = sharedList;
    }
}
