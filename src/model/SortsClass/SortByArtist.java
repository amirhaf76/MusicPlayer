package model.SortsClass;

import model.Media;
import model.Music;
import java.util.Comparator;

public class SortByArtist implements Comparator<Media> {

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
