package network;

import Model.Music;
import Model.enumeration.Command;
import java.io.Serializable;
import java.util.ArrayList;

public class Package implements Serializable {
    private final ArrayList<Command> commands;
    private final ArrayList<Music> requestedSharedMusic;
    private final Music getMusic;
    private final byte[] data;
    private final boolean endDownload;

    private static final long serialVersionUID = 1396461L;


    public Package(ArrayList<Command> commands, ArrayList<Music> requestedSharedMusic,
                   Music getMusic, byte[] data, boolean endDownload) { // date : data of getMusic
        this.commands = commands;
        this.requestedSharedMusic = requestedSharedMusic;
        this.getMusic = getMusic;
        this.data = data;
        this.endDownload = endDownload;
    }
    // TODO: 6/26/2019 sharedList


    public ArrayList<Command> getCommands() {
        return commands;
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
