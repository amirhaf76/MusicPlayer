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


    public void loadUser() {
        for (User u :
                users) {
        }
    }
}
