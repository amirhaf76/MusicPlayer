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


    public void add(Media media) {

        if ( media instanceof Music ) {
            if ( !medium.contains(media) ) {
                medium.add(media);
            }
        }

        if ( media instanceof Video ) {
            // TODO: 6/20/2019 video properties
        }
    }
    public void remove(Media media) {
        medium.remove(media);
    }



}
