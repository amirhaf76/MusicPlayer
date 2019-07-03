package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable {

    // identification of User
    private String name;
    private String password;
    private ArrayList<Client> friends = new ArrayList<>();
    private PlayList library = new PlayList("library");
    private ArrayList<PlayList> playLists = new ArrayList<>();

    // serializable
    private static final long serialVersionUID = 13984122L;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Client> getFriends() {
        return friends;
    }

    public PlayList getLibrary() {
        return library;
    }

    public ArrayList<PlayList> getPlayLists() {
        return playLists;
    }

    /**
     * setter method for load User
     */

    public void setLibrary(PlayList library) {
        this.library = library;
    }

    public void setPlayLists(ArrayList<PlayList> playLists) {
        this.playLists = playLists;
    }


    public ArrayList<Music> getFavoritesMusic() {
        ArrayList<Music> favoritesMusic = new ArrayList<>();

        for ( Music m : library.getMusic() )
            if ( m.isFavorite() ) favoritesMusic.add(m);

        return favoritesMusic;
    }

    public ArrayList<Music> getSharedMusic() {
        ArrayList<Music> sharedMusic = new ArrayList<>();

        for ( Music m : library.getMusic() )
            if ( m.isSharedMusic() ) sharedMusic.add(m);

        return sharedMusic;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
