package Model.SortsClass;

import Model.Media;
import Model.Music;

import java.io.Serializable;
import java.util.Comparator;

public class SortByArtist implements Comparator<Media> , Serializable {

    @Override
    public int compare(Media o1, Media o2) {
        if ( o1 instanceof Music && o2 instanceof Music ) {
            return ((Music) o1).getArtist().getName().
                    compareToIgnoreCase(
                            ((Music) o2).getArtist().getName() );

        }

        return 0;
    }
}
