package model.SortsClass;

import model.Media;
import model.Music;

import java.util.Comparator;

public class SortByTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if ( o1 instanceof Music && o2 instanceof Music ) {
            return o1.getLastTime().compareTo(o2.getLastTime());
        }
        return 0;
    }
}
