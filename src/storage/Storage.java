package storage;

import Model.Jpotify;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;

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
                    new FileOutputStream(
                           file
                    )
            );
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error in saving user!",
                    null, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }



}
