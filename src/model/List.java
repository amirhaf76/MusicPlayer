package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class List implements Serializable {

    private String name;
    private ArrayList<Media> medium = new ArrayList<>();

    private static final long serialVersionUID = 1398442L;

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
        medium.add(media);
    }
    public void remove(Media media) {
        medium.remove(media);
    }

    public ArrayList<Music> getMusic() {
        ArrayList<Music> musics = new ArrayList<>();
        for (Media m :
                medium) {
            if ( m instanceof Music ) {
                musics.add((Music) m);
            }
        }
        return  musics;
    }

    // TODO: 6/25/2019 public ArrayList<Video> getVideo(){}

}
