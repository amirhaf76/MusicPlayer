package Test.TestStorage;

import Model.Library;
import Model.User;
import org.junit.jupiter.api.Test;
import storage.LoadFile;
import storage.Storage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class StorageAndLoadFileTest {
    private static User user1;
    private static User user2;

    static {
        user1 = new User("jack", "123");
        user2 = new User("jan", "456");
    }

    @Test
    void saveData() {
        Storage.makeDataFolder();
        Storage.makeUserFolder(user1.getName());
        Storage.makeUserFolder(user2.getName());

        Storage.saveJustUser(user1);
        Storage.saveJustUser(user2);

        Storage.saveJustLibrary(user1);
        Storage.saveJustLibrary(user2);

        File fileUser1 = new File("Data\\" + user1.getName() +
                "\\" + "User_" + user1.getName()
        );
        File fileUser2 = new File("Data\\" + user2.getName() +
                "\\" + "User_" + user2.getName()
        );

        File libraryUser1 = new File("Data\\" + user1.getName() +
                "\\" + "Library_" + user1.getName()
        );
        File libraryUser2 = new File("Data\\" + user2.getName() +
                "\\" + "Library_" + user2.getName()
        );



        assertNotNull(fileUser1);
        assertNotNull(fileUser2);

        assertNotNull(libraryUser1);
        assertNotNull(libraryUser2);


        User loadedUser1;
        User loadedUser2;

        Library loadedLibrary1;
        Library loadedLibrary2;



        loadedUser1 = LoadFile.loadUser(user1.getName());
        loadedUser2 = LoadFile.loadUser(user2.getName());

        loadedLibrary1 = LoadFile.loadLibrary(user1.getName());
        loadedLibrary2 = LoadFile.loadLibrary(user2.getName());


        assertEquals(user1, loadedUser1);
        assertEquals(user2, loadedUser2);

        assertEquals(user1.getLibrary(), loadedLibrary1);
        assertEquals(user2.getLibrary(), loadedLibrary2);

        System.out.println("Testing of Storage is completed.");
    }
}