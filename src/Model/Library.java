package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {

    private ArrayList<Media> medium = new ArrayList<>();
    private final List FAVORITES = new List("Favorites");
    private final List SHRAEDLIST = new List("Shared List");
    private ArrayList<List> playList = new ArrayList<>();

    private static final long serialVersionUID = 139843L;

    public void addMediaToLibrary(Media media) {
        medium.add(media);
    }

    public void removeMediaFromLibrary(Media media) {
        medium.remove(media);
    }

    public void addMediaToFavorites(Media media) {
        FAVORITES.add(media);
    }

    public void removeMediaFromFavorites(Media media) {
        FAVORITES.remove(media);
    }

    public void addMediaToSHRAEDLIST(Media media) {
        SHRAEDLIST.add(media);
    }

    public void removeMediaToSHRAEDLIST(Media media) {
        SHRAEDLIST.remove(media);
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

}
