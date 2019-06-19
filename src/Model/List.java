package Model;

import java.util.ArrayList;

public class List {

    private String name;
    protected ArrayList<Media> medium = new ArrayList<>();

    public List(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Media> getMedium() {
        return medium;
    }

    // TODO: 6/18/2019 add add and remove method with array of medium as input

    public void add(Media media) {
        medium.add(media);
    }
    public void remove(Media media) {
        medium.remove(media);
    }



}
