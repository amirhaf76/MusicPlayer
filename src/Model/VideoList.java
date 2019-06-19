package Model;

public class VideoList extends List {

    public VideoList(String name) {
        super(name);
    }


    public void add(Media media) {
        if ( media instanceof Video ) {
            medium.add(media);
        }
    }


    public void remove(Media media) {
        if ( media instanceof Video ) {
            medium.remove(media);
        }
    }
}
