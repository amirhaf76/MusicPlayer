package Model;

import java.io.Serializable;

public class MusicList extends List implements Serializable {

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
