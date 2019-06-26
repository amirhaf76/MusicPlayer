package network;

import Model.Music;
import Model.enumeration.Command;

import java.util.ArrayList;

public class Package {
    private final ArrayList<Command> commands;
    private final ArrayList<Music> SharedMusic;
    private DownloadFile downloadFile;

    public Package(ArrayList<Command> commands, ArrayList<Music> sharedMusic) {
        this.commands = commands;
        SharedMusic = sharedMusic;
    }
    // TODO: 6/26/2019 sharedList
}
