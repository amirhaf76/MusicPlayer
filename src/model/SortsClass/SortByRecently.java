package Model.SortsClass;

import Model.Media;
import Model.Music;

import java.io.Serializable;
import java.util.Comparator;

public class SortByRecently implements Comparator<Media>, Serializable {
    @Override
    public int compare(Media o1, Media o2) {
        if ( o1 instanceof Music && o2 instanceof Music ) {
            return o1.getLastTime().compareTo(o2.getLastTime());
        }
        return 0;
    }
}
