package network;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Server extends Thread {

    private final ServerSocket server;
    private ArrayList<ClientHandler> clients = new ArrayList<>();


    public Server() throws IOException {
        this.server = new ServerSocket(1398);
    }

    @Override
    public void run() {
        Socket newClient;
        ClientHandler clientHandler;

        while ( true ) {
            try {
                newClient = server.accept();

                clientHandler = new ClientHandler(newClient);

                clients.add(clientHandler);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeServer() throws IOException {
        for (ClientHandler c: clients) {
            c.closeHandler();
        }
        server.close();
    }

    public boolean containsClient(InetAddress ip) {
        // TODO: 6/25/2019 does server have this ip
//        return clients.contains()
        return false;
    }

}
