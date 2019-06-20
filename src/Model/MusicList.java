package Model;

public class MusicList extends List {

    public MusicList(String name) {
        super(name);
    }

    public void addMusic(Media media) { // add media if...
        if ( media instanceof Music) { // if media is Music, ...
            super.add(media);
        }
    }

    public void removeMusic(Media media) { // remove media if ...
        if ( media instanceof  Music ) { // if media is Music, ...
            super.remove(media);
        }

    }

}
