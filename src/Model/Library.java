package Model;

import Model.SortsClass.SortByAlbum;
import Model.SortsClass.SortByArtist;
import Model.SortsClass.SortByRecently;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {

    private ArrayList<Media> medium = new ArrayList<>();
    private final List FAVORITES = new List("Favorites");
    private final List SHRAEDLIST = new List("Shared List");
    private ArrayList<List> playList = new ArrayList<>();

    private static final long serialVersionUID = 139843L;

    private void addMediaToLibrary(Media media) {
        medium.add(media);
    }

    private void removeMediaFromLibrary(Media media) {
        medium.remove(media);
    }

    private void addMediaToFavorites(Media media) {
        FAVORITES.add(media);
    }

    private void removeMediaFromFavorites(Media media) {
        FAVORITES.remove(media);
    }

    private void addMediaToSHRAEDLIST(Media media) {
        SHRAEDLIST.add(media);
    }

    private void removeMediaToSHRAEDLIST(Media media) {
        SHRAEDLIST.remove(media);
    }




}
