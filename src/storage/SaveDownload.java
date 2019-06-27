package storage;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SaveDownload {


    private boolean end = false;
    private final File file;

    public SaveDownload(String userName, String name){

        // first make folder, then make file
        file = makeFile(makeFolder(userName), name);
    }

    private String makeFolder(String userName) {
        String path = userName + "(Download)";
        File folder = new File(userName + "(Download)");
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

    public boolean isEnd() {
        return end;
    }

    public void end() {
        this.end = true;
    }

}
