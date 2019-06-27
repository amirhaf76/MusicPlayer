package storage;

import Model.Library;
import Model.User;

import java.io.*;

public class ReloadFile {

    private final String parent;
    private final User user;

    public ReloadFile(User user) {
        this.user = user;
        parent = "User:" + user.getName();
    }

    public User reloadUser() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(
                new File(parent + "\\" + user.getName() + ".ur")
        );
        ObjectInputStream in = new ObjectInputStream(file);

        return (User) in.readObject();
    }

    public Library reloadLibrary() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(
                new File(parent + "\\" + user.getName() + ".lb")
        );
        ObjectInputStream in = new ObjectInputStream(file);

        return (Library) in.readObject();
    }
}
