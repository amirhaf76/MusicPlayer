package storage;


import Model.Library;
import Model.User;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadFile {

    public static User loadUser(String name) {
        User user = null;

        File userFile = new File(Storage.getParent() + "\\" +
                name + "\\" +
                "User_" + name
        );

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(userFile)
            );
            user = (User) ois.readObject();
            ois.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error in loading User " + name,
                    null, JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Error in loading User " + name + '\n' +
                    "There is problem in type of \n" +
                    userFile.getPath(),
                    null, JOptionPane.ERROR_MESSAGE);
        }

        return user;
    }


    public static Library loadLibrary(String name) {
        Library library = null;

        File libraryFile = new File(Storage.getParent() + "\\" +
                name + "\\" +
                "Library_" + name
        );

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(libraryFile)
            );
            library = (Library) ois.readObject();
            ois.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error in loading Library " + name,
                    null, JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Error in loading Library " + name + '\n' +
                            "There is problem in type of \n" +
                            libraryFile.getPath(),
                    null, JOptionPane.ERROR_MESSAGE);
        }

        return library;
    }
}
