package model;

import model.SortsClass.SortByAlbum;
import model.SortsClass.SortByArtist;
import model.SortsClass.SortByRecently;
import java.util.ArrayList;

public class List extends ArrayList<Media> {

    private String name;

    public List(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ArrayList<Music> getMusic() {
        ArrayList<Music> musics = new ArrayList<>();
        for (Media m :
                this) {
            if ( m instanceof Music ) {
                musics.add((Music) m);
            }
        }
        return  musics;
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
    // TODO: 6/25/2019 public ArrayList<Video> getVideo(){}

}
