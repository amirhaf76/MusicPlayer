package storage;

import model.User;
import javax.swing.*;
import java.io.*;

public class Storage {

    private static String parent = "Data";

    public static boolean makeDataFolder() {
        return new File(parent).mkdir();
    }

    public static boolean makeUserFolder(String name) {
        File folder = new File(parent + "\\" + name);
        return folder.mkdir();
    }

    public static void saveJustUser(User user) {
        File file = new File(parent +
                "\\" + user.getName() +
                "\\" + "User_" +
                user.getName()
        );

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(file)
            );
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error in saving user!",
                    null, JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void saveJustLibrary(User user) {
        File file = new File(parent + "\\" +
                user.getName() + "\\" +
                "Library_" + user.getName()
        );

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(file)
            );
            oos.writeObject(user.getLibrary());
            oos.close();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error in saving Library!",
                    null, JOptionPane.ERROR_MESSAGE);

        }
    }

    public static String getParent() {
        return parent;
    }

    public static void setParent(String parent) {
        Storage.parent = parent;
    }
}
