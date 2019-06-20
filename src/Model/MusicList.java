package Model;

public class MusicList extends List {

    public MusicList(String name) {
        super(name);
    }

    public void add(Media media) { // add media if...
        if ( media instanceof Music) { // if media is Music, ...
            medium.add(media);
        }
    }

    public void remove(Media media) { // remove media if ...
        if ( media instanceof  Music ) { // if media is Music, ...
            medium.remove(media);
        }

    }

}
