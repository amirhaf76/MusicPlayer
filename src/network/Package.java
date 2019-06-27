package network;

import Model.Music;
import Model.enumeration.Command;
import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable {
    // request
    private final ArrayList<Command> request;

    // requested list of shared music
    private final ArrayList<Music> requestedSharedMusic;

    // music that is requested
    private final Music getMusic;

    // data of music which is requested
    private final byte[] data;

    // the end of sending data of requested music
    private final boolean endDownload;

    private static final long serialVersionUID = 1396461L;


    public Package(ArrayList<Command> request, ArrayList<Music> requestedSharedMusic,
                   Music getMusic, byte[] data, boolean endDownload) { // date : data of getMusic
        this.request = request;
        this.requestedSharedMusic = requestedSharedMusic;
        this.getMusic = getMusic;
        this.data = data;
        this.endDownload = endDownload;
    }
    // TODO: 6/26/2019 sharedList


    public ArrayList<Command> getRequest() {
        return request;
    }

    public ArrayList<Music> getRequestedSharedMusic() {
        return requestedSharedMusic;
    }

    public byte[] getData() {
        return data;
    }

    public Music getGetMusic() {
        return getMusic;
    }

    public boolean isEndDownload() {
        return endDownload;
    }
}
