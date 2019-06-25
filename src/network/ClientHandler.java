package network;

import Model.Command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Comparator;

public class ClientHandler implements Runnable {

    private final DataInputStream dis;
    private final DataOutputStream dom;
    private final Socket client;
    private final Object lock = new Object();

    private ArrayList<Command> commands = new ArrayList<>();


    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.dis = new DataInputStream(client.getInputStream());
        this.dom = new DataOutputStream(client.getOutputStream());
    }

    public void closeHandler() throws IOException {
        synchronized (lock) {
            dis.close();
            dom.close();
            client.close();
        }
    }

    @Override
    public void run() {

    }

    public SocketAddress getAddressOfEndPoint() {
        return client.getLocalSocketAddress();
    }

    public void addCommand(Command command) {
        if ( !commands.contains(command) ) {
           commands.add(command);
        }
    }

    public ArrayList<Command> sendCommands() {
        ArrayList<Command> commands = new ArrayList<>(this.commands);
        this.commands.removeAll(commands);
        return commands;
    }



}
