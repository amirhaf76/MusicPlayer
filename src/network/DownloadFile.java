package network;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DownloadFile {
    private final File file;
    private long part;
    private final int mgByte = 1024 * 1024;

    public DownloadFile(File file) {
        this.file = file;
    }

    public void takeAPart() throws FileNotFoundException {
        Scanner in = new Scanner(file);
    }
}
