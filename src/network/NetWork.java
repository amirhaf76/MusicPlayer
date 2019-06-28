package network;

import Model.User;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;

public class NetWork {

    private final User user;
    private final Manager manager;

    public NetWork(User user) throws IOException {
        this.user = user;
        this.manager = new Manager(this);
    }

    public void runNetwork() throws IOException {
        manager.addClientHandler( makeConnection(user.getFriends()) );
        manager.start();
        manager.getServer().start();
    }



    // make connection with user's friends who are online
    private HashMap<InetAddress, ClientHandler> makeConnection(ArrayList<InetAddress> friends) throws IOException {
        HashMap<InetAddress, ClientHandler> clientHandlers = new HashMap<>();

        for (InetAddress ip :
                friends) {
            ClientHandler cH;

            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(ip, 1398); // all of client listen in port 1398

            socket.bind(socketAddress); // ???
            socket.connect(socketAddress);

            clientHandlers.put(ip, new ClientHandler(user, socket, manager));

        }

        return clientHandlers;
    }

    public void closeNetwork() throws IOException {
        manager.shutdownManager();
    }

    public Manager getManager() {
        return manager;
    }

    public User getUser() {
        return user;
    }

    public ClientHandler getClientHandler(InetAddress ip) {
        return manager.getClientHandlerHashMap().get(ip);
    }

}
