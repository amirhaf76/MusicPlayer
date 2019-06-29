package Model;

import Model.SortsClass.SortByAlbum;
import Model.SortsClass.SortByArtist;
import Model.SortsClass.SortByRecently;
import storage.ReloadFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Jpotify implements Serializable {

    private ArrayList<User> users = new ArrayList<>();



    public ArrayList<User> getUsers() {
        return users;
    }



    public void addUser(User user) {
        users.add(user);
    }
    public static void sortByArtist(ArrayList<Media> medium) {
        medium.sort(new SortByArtist() );
    }
    public static void sortByAlbum(ArrayList<Media> medium) {
        medium.sort(new SortByAlbum());
    }
    public static void sortByRescntly(ArrayList<Media> medium) {
        medium.sort(new SortByRecently());
    }

    public void loadUser() {
        for (User u :
                users) {
            u.setMusicController(new MusicController());
        }
    }
}
