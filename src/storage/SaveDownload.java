package storage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import static javax.swing.JOptionPane.*;

public class SaveDownload {


    private boolean end = false;
    private final File file;

    public SaveDownload(String userName, String name){
        file = makeFile(makeFolder(userName), name);
    }

    private String makeFolder(String userName) {
        String path = Storage.getParent() + "\\" +
                userName + "\\" +
                userName + "_(Download)";

        File folder = new File(path);

        if ( !folder.isDirectory() ) {
            if ( !folder.mkdir() ) {
                JOptionPane.showMessageDialog( new Frame(),
                        "There is problem in saving download",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return path;
    }

    private File makeFile(String path, String name) {
        return new File(path + "\\" + name);
    }

    public void saveData(byte[] data) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(raf.length());

        raf.write(data);

        raf.close();

    }

    public File getDownloadFile() {
        return file;
    }

    public boolean isEnd() {
        return end;
    }

    public void end() {
        this.end = true;
    }

}
