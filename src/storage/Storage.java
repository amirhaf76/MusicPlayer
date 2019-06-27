package storage;

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

    public void makeFile() {
        File file = new File( parent );
        if ( !file.isDirectory() ) {
            if ( !file.mkdir() ) {
                JOptionPane.showMessageDialog( new Frame(),
                        "There is problem in making folder",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void saveUser() throws IOException {
        FileOutputStream savedFile = new FileOutputStream(
                new File(parent + "\\" + user.getName() + ".ur")
        );
        ObjectOutputStream out = new ObjectOutputStream(savedFile);
        out.writeObject(user);

        out.close();
        savedFile.close();

    }

    public void saveLibrary() throws IOException {
        FileOutputStream savedFile = new FileOutputStream(
                new File(parent + "\\" + user.getName() + ".b" )
        );
        ObjectOutputStream out = new ObjectOutputStream(savedFile);
        out.writeObject(user.getLibrary());

        out.close();
        savedFile.close();
    }


}
