package network;

import java.io.IOException;
import java.net.*;

public class Server extends Thread {

    private final ServerSocket server;
    private final Manager manager;
    private boolean closed = false;




    public Server(Manager manager) throws IOException {
        this.server = new ServerSocket(1398);
        this.manager = manager;
    }

    @Override
    public void run() {

        while ( true ) {
            System.out.println("Server Running ...");
            Socket newClient;
            ClientHandler clientHandler;
            try {
                System.out.println("waiting");
                newClient = server.accept();
                System.out.println("welcome");

                clientHandler = new ClientHandler(manager.getNetWork().getUser(), newClient, manager);

                manager.addClientHandler(newClient.getInetAddress() ,clientHandler);
                System.out.println("end");

            } catch (IOException e) {
                closed = true;
            }
        }
    }

    public boolean isClosed() {
        return closed;
    }

    public void close() throws IOException {
        closed = true;
        server.close();
    }


}
