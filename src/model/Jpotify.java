package model;

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
