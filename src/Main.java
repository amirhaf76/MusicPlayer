import Model.Jpotify;
import Model.Music;
import Model.User;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;
import java.sql.Time;

public class Main{

    public static void main(String[] args) throws IOException, InvalidDataException, UnsupportedTagException {
        Jpotify jpotify = new Jpotify();
        User firstUser = new User("amin", "123456789");
        String path = "src\\Test\\FileOfTest\\";
        Music music1 = new Music(new File(path+"Hymn For The Weekend - Coldplay.mp3"),
                new Time(System.currentTimeMillis()));
        Music music2 = new Music(new File(path+"Homemade Dynamite Remix - Lorde.mp3"),
                new Time(System.currentTimeMillis()));
        Music music3 = new Music(new File(path+"Natural - Imagine Dragons.mp3"),
                new Time(System.currentTimeMillis()));

        firstUser.getLibrary().addMediaToLibrary(music1);
        firstUser.getLibrary().addMediaToLibrary(music2);
        firstUser.getLibrary().addMediaToLibrary(music3);

        jpotify.addUser(firstUser);
        GUI_1 GUI_1 = new GUI_1();
        GUI_1.setJpotify(jpotify);
        /**( try(final DatagramSocket socket = new DatagramSocket()){
         *socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
           *  System.out.println(socket.getLocalAddress().getHostAddress());
         *} catch (SocketException e) {
          *   e.printStackTrace();
         *} catch (UnknownHostException e) {
          *   e.printStackTrace();
         }
         */
    }
}