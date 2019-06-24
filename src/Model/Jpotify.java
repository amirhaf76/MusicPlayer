package Model;

import Model.SortsClass.SortByAlbum;
import Model.SortsClass.SortByArtist;
import Model.SortsClass.SortByRecently;

import java.util.ArrayList;

public class Jpotify {
    private ArrayList<User> users = new ArrayList<>();

    public static void sortByArtist(ArrayList<Media> medium) {
        medium.sort(new SortByArtist() );
    }
    public static void sortByAlbum(ArrayList<Media> medium) {
        medium.sort(new SortByAlbum());
    }
    public static void sortByRescntly(ArrayList<Media> medium) {
        medium.sort(new SortByRecently());
    }
}
