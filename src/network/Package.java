package network;

import model.Music;

import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable {

    // requested list of shared music
    private final ArrayList<Music> SharedMusic;

    // music that sender requested
    private final Music downloadMusic;

    // data of music which is requested
    private final byte[] data;

    private static final long serialVersionUID = 1396461L;


    public Package(ArrayList<Music> SharedMusic,
                   Music getMusic, byte[] data) { // date : data of getMusic
        this.SharedMusic = SharedMusic;
        this.downloadMusic = getMusic;
        this.data = data;
    }
    // TODO: 6/26/2019 sharedList
    

    public ArrayList<Music> getSharedMusic() {
        return SharedMusic;
    }

    public byte[] getData() {
        return data;
    }

    public Music getGetMusic() {
        return downloadMusic;
    }

}
