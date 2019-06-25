package Model.SortsClass;

import Model.Media;
import Model.Music;

import java.util.Comparator;

public class SortByAlbum implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        if ( o1 instanceof Music && o2 instanceof Music ) {
            return ((Music) o1).getAlbum().getName().
                    compareToIgnoreCase(
                            ((Music)o2).getAlbum().getName()
                    );
        }

        return 0;
    }
}
