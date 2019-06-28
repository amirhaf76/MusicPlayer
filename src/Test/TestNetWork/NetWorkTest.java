package Test.TestNetWork;

import Model.Music;
import Model.User;
import Model.enumeration.Command;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import network.*;
import network.Package;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private ArrayList<Command> request = new ArrayList<>();
    private byte[] bytes = new byte[]{8,9,4,6,7};
    private String path = "I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\src\\Test\\FileOfTest\\";

    private User user;
    private NetWork netWork;
    private Manager manager;
    private Server server;

    private User user2;
    private NetWork netWork2;
    private Manager manager2;
    private Server server2;

    void setUp() throws IOException, InvalidDataException, UnsupportedTagException {
        user = new User("hamid", "1398");
        netWork = new NetWork(user);
        manager = netWork.getManager();
        server = manager.getServer();

        user2 = new User("amir", "1400");
        netWork2 = new NetWork(user);
        manager2 = netWork.getManager();
        server2 = manager.getServer();

        music = new Music(new File(path+"Homemade Dynamite Remix - Lorde.mp3"),
                new Time(System.currentTimeMillis()));
        musics.add(music);
        request.add(Command.STATUS);
        request.add(Command.DOWNLOAD);
        aPackage = new Package(request,musics,music,bytes,false);
    }

    @Test
    void Client() throws IOException {
        Socket client  = new Socket("localhost",1398);
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois  = new ObjectInputStream(client.getInputStream());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.close();
    }

    @Test
    void testServer() throws IOException, InvalidDataException, UnsupportedTagException {
        setUp();

        assertFalse(server.isClosed());
        assertFalse(server.isAlive());

        server.setDaemon(false);
        server.setDaemon(false);
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


        manager.start();
        server.start();

        Socket client  = new Socket("localhost",1398);
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois  = new ObjectInputStream(client.getInputStream());
       System.out.println( manager.getClientHandlerHashMap().get(InetAddress.getByName("localHost")).getClient().getInetAddress() );
        for (ClientHandler ch :
                manager.getClientHandlerHashMap().values()){
            ch.downloadMusic(music);
            System.out.println(ch.getClient().getInetAddress());
        }

        oos.writeObject(aPackage);
        oos.flush();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        manager.shutdownManager();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}