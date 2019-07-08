package Model;


import java.util.ArrayList;

public class MusicList {

    private ArrayList<Music> musics = new ArrayList<>();

    private transient final Object lock;

    public MusicList() {
        lock = new Object();
    }


    public void addMusic(Media media) {
        synchronized (lock) {
            if ( media instanceof Music ) { // if media is Music, ...

                if ( !musics.contains(media) ) { // if there is not any music like media, ...
                    musics.add((Music) media);
                }
            }
        }
    }

    public Object getLock() {
        return lock;
    }

    public void addMusic(ArrayList<Media> medium) {
        synchronized (lock) {
            for (Media m : // for all medium
                    medium) {
                this.addMusic(m);
            }
        }

    }

    public void removeAllMusics() {
        synchronized (lock) {
            musics.removeAll(musics.subList(0, musics.size()));
        }
    }

    public void removeMusic(Music music) {
        synchronized (lock) {
            musics.remove(music);
            musics.trimToSize();
        }
    }

    public ArrayList<Music> getMusics() {
        return musics;
    }
}
