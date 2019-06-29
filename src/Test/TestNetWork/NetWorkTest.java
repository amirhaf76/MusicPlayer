package Test.TestNetWork;

import Model.Music;
import Model.User;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import network.*;
import network.Package;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("Duplicates")
class NetWorkTest {

    private Package aPackage;
    private ArrayList<Music> musics = new ArrayList<>();
    private Music music;
    private byte[] bytes = new byte[]{8,9,4,6,7};
    private String path = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";

    private User user;
    private NetWork netWork;
    private Manager manager;
    private Server server;

    void setUp() throws IOException, InvalidDataException, UnsupportedTagException {
        user = new User("hamid", "1398");
        manager = netWork.getManager();
        server = manager.getServer();

        music = new Music(new File(path+"Homemade Dynamite Remix - Lorde.mp3"),
                new Time(System.currentTimeMillis()));
        musics.add(music);
        aPackage = new Package(musics,music,bytes);
    }

    @Test
    void testServer() throws IOException, InvalidDataException, UnsupportedTagException {
        setUp();

        assertFalse(server.isClosed());
        assertFalse(server.isAlive());

        server.start();

        Socket client  = new Socket("localhost",1398);
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois  = new ObjectInputStream(client.getInputStream());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        client.close();
        assertTrue(client.isClosed());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        server.close();
        server.stop();
    }


    @Test
    void Manager() throws IOException, InvalidDataException, UnsupportedTagException {
        setUp();

        System.out.println(Inet4Address.getLocalHost().getHostAddress());
        System.out.println(server.getState());
//        server.start();

        InetAddress ip = InetAddress.getByName("localhost");
        Socket client  = new Socket(ip,1398);
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois  = new ObjectInputStream(client.getInputStream());

//        manager.start();
//        manager.getClientHandlerHashMap().get(ip).downloadMusic(music);

        oos.writeObject(aPackage);
        oos.flush();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        manager.shutdownManager();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}