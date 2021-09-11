package model;

import java.util.ArrayList;
import java.util.Objects;

public class PlayList extends ArrayList<Media> {

    private final String name;

    public PlayList(String name) {
        this.name = name;
    }

    public ArrayList<Music> getMusic() {
        ArrayList<Music> musics = new ArrayList<>();

        for (Media m :this)
            if ( m instanceof Music ) musics.add((Music) m);

        return musics;
    }

    // TODO: 7/3/2019 Video

    public void restPlayList() {
        this.removeAll(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlayList media = (PlayList) o;
        return name.equals(media.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "name='" + name + '\'' +
                ", modCount=" + modCount +
                '}';
    }
}
