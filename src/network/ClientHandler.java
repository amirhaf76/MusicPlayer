package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final DataInputStream dis;
    private final DataOutputStream dom;


    public ClientHandler(Socket client) throws IOException {
        this.dis = new DataInputStream(client.getInputStream());
        this.dom = new DataOutputStream(client.getOutputStream());
    }

    public void closeHandler() {
        // TODO: 6/25/2019  close handler
    }

    @Override
    public void run() {

    }
}
