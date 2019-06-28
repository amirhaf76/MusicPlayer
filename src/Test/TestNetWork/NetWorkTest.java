package Test.TestNetWork;

import Model.User;
import network.Manager;
import network.NetWork;
import network.Server;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import static org.junit.jupiter.api.Assertions.*;

class NetWorkTest {

    private User user;
    private NetWork netWork;
    private Manager manager;
    private Server server;

    private User user2;
    private NetWork netWork2;
    private Manager manager2;
    private Server server2;

    void setUp() throws IOException {
        user = new User("hamid", "1398");
        netWork = new NetWork(user);
        manager = netWork.getManager();
        server = manager.getServer();

        user2 = new User("amir", "1400");
        netWork2 = new NetWork(user);
        manager2 = netWork.getManager();
        server2 = manager.getServer();
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
    void testServer() throws IOException {
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
}