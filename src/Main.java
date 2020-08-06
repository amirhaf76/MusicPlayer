import model.Jpotify;
import model.User;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import storage.ReloadFile;
import storage.Storage;

import java.io.File;
import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException, InvalidDataException, UnsupportedTagException {
//        Jpotify jpotify = new Jpotify();
        User firstUser = new User("amin", "123456789");
//        String path = "src\\Test\\FileOfTest\\";
//        Music music1 = new Music(new File(path+"Hymn For The Weekend - Coldplay.mp3"),
//                new Time(System.currentTimeMillis()));
//        Music music2 = new Music(new File(path+"Homemade Dynamite Remix - Lorde.mp3"),
//                new Time(System.currentTimeMillis()));
//        Music music3 = new Music(new File(path+"Natural - Imagine Dragons.mp3"),
//                new Time(System.currentTimeMillis()));
//
//        firstUser.getLibrary().addMediaToLibrary(music1);
//        firstUser.getLibrary().addMediaToLibrary(music2);
//        firstUser.getLibrary().addMediaToLibrary(music3);
//        jpotify.addUser(firstUser);
//
//
//
//        GUI_1 GUI_1 = new GUI_1();
//        GUI_1.setJpotify(jpotify);
        Jpotify jpotify;
        File file;
        try {
            file = new File("Jpotify.j");
            jpotify = ReloadFile.loadJpotify(file);
            jpotify.loadUser();


            GUI_1 GUI_1 = new GUI_1();
            GUI_1.setJpotify(jpotify);

        } catch (ClassNotFoundException e) {
            System.out.println("error in opening");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("there is not any Jpotify.j");
            jpotify = new Jpotify();
            Storage.saveJpotify(jpotify);
            GUI_1 GUI_1 = new GUI_1();
            GUI_1.setJpotify(jpotify);
        }





    }
}