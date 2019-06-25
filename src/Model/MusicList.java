package Model;

public class MusicList extends List {

    public MusicList(String name) {
        super(name);
    }

    @Override
    public void add(Media media) { // add media if...
        if ( media instanceof Music) { // if media is Music, ...
            super.add(media);
        }
    }

    @Override
    public void remove(Media media) { // remove media if ...
        if ( media instanceof  Music ) { // if media is Music, ...
            super.remove(media);
        }

    }

}
