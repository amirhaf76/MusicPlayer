package storage;

import Model.Jpotify;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Storage {

    private final String parent;
    private final User user;


    public Storage(User user) {
        this.user = user;
        parent = "User:" + user.getName();
    }

    static public void saveJpotify(Jpotify jpotify) throws IOException {
        File file = new File("Jpotify.j");

        if ( !file.exists() ) {
            if ( !file.createNewFile()) {
                JOptionPane.showMessageDialog( new Frame(),
                        "There is problem in making folder",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        FileOutputStream savedFile = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(savedFile);
        out.writeObject(jpotify);
        out.close();
        savedFile.close();
    }


}
