package model;


import model.SortsClass.SortByTitle;

import java.util.ArrayList;
import java.util.*;

public class MusicList {

    private final ArrayList<Music> musics = new ArrayList<>();
    private int currentMusic = 0;

    private final String lock = "LOCK";

    public void addMusic(Media media) {
        synchronized (lock) {
            if ( media instanceof Music ) { // if media is Music, ...

                if ( !musics.contains(media) ) { // if there is not any music like media, ...
                    musics.add((Music) media);
                }
            }
        }
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
            currentMusic = 0;
            musics.removeAll(musics.subList(0, musics.size()));
        }
    }

    public void removeMusic(Music music) {
        synchronized (lock) {
            if ( musics.contains(music) ) {
                if ( currentMusic >= musics.indexOf(music))
                    currentMusic--;
                musics.remove(music);
                musics.trimToSize();
            }
        }
    }

    public Iterator<Music> getMusics() {
        return musics.iterator();
    }

    public Music getMusic(){
        synchronized (lock) {
            if ( !musics.isEmpty() )
                return musics.get(currentMusic);
            return null;
        }
    }

    public Music nextMusic(){
        synchronized (lock) {
            if ( !musics.isEmpty() ) {
                currentMusic = (currentMusic + 1) % musics.size();
                return musics.get(currentMusic);
            }
            return null;
        }
    }

    public Music previousMusic(){
        synchronized (lock) {
            if ( !musics.isEmpty() ) {
                currentMusic = (currentMusic - 1) % musics.size();
                return musics.get(currentMusic);
            }
            return null;
        }
    }

    public void shuffleMusics() {
        synchronized (lock) {
            Collections.shuffle(musics);
        }
    }

    public void alphabeticalSortMusics() {
        synchronized (lock) {
            musics.sort(new SortByTitle());
        }
    }
}
