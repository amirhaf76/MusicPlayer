package network;

import Model.enumeration.Command;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private final BufferedReader buffer;
    private final PrintWriter out;
    private final Socket client;
    private final Object lock = new Object();

    private ArrayList<Command> commands = new ArrayList<>();


    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.buffer = new BufferedReader(new InputStreamReader(client.getInputStream()) );
        this.out = new PrintWriter(client.getOutputStream());
    }

    public void closeHandler() throws IOException {
        synchronized (lock) {
            buffer.close();
            out.close();
            client.close();
        }
    }

    @Override
    public void run() {
        // phase 1 : send command
        addCommand(Command.STATUS); // get status is automatic command

    }

    public SocketAddress getAddressOfEndPoint() {
        return client.getLocalSocketAddress();
    }

    public void addCommand(Command command) {
        if ( !commands.contains(command) ) {
           commands.add(command);
        }
    }

    public void sendCommands(PrintWriter out, ArrayList<Command> commands) throws IOException {
        out.print(commands);
        out.flush();
        commands.removeAll( commands.subList(0,commands.size()) );
    }

    public void answerToCommand(ArrayList<Command> commands) {
        for (Command c :
                commands) {
            switch (c) { // TODO: 6/25/2019 complete this part
                case DOWNLOAD:
                    break;
                case STATUS:
                    break;
                case SHAREDLIST:
                    break;
                case SHAREDMUSIC:
                    break;
            }
        }
    }

    public void getAnswer() {

    }


}
