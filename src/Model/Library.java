package Model;

import Model.SortsClass.SortByArtist;

import java.util.ArrayList;

public class Library {

    private ArrayList<Media> medium = new ArrayList<>();
    private final List FAVORITES = new List("Favorites");
    private final List SHRAEDLIST = new List("Shared List");
    private ArrayList<List> playList = new ArrayList<>();

    public static void sortByArtist(ArrayList<Media> medium) {
        medium.sort(new SortByArtist() );
    }


}
