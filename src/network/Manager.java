package network;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager extends Thread {

    private HashMap<InetAddress, ClientHandler> clientHandlerHashMap = new HashMap<>();
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private boolean closed = false;
    private final Object lock = new Object();

    private final NetWork netWork;
    private final Server server;

    public Manager(NetWork netWork) throws IOException {
        this.netWork = netWork;
        this.server = new Server(this);
    }

    @Override
    public void run() {
        System.out.println("Running manager ...");
        while ( !closed ) {
            synchronized (lock) {
                for (ClientHandler cH :
                        clientHandlerHashMap.values()) {
                    pool.execute(cH);
                }
            }
        }
        System.out.println("check");
    }

    public void addClientHandler(InetAddress ip,ClientHandler cH) {
        synchronized (lock) {
            clientHandlerHashMap.put(ip, cH);
        }
    }

    public void addClientHandler(HashMap<InetAddress, ClientHandler> cHS) {
        synchronized (lock) {
            clientHandlerHashMap.putAll(cHS);
        }
    }

    public void removeClientHandler(ClientHandler clientHandler) {
        synchronized (lock) {
            InetAddress inetAddress = clientHandler.getClient().getInetAddress();
            clientHandlerHashMap.remove(inetAddress);
        }
    }

    public void shutdownManager() throws IOException {
        synchronized (lock) {
            if ( this.getState() == State.RUNNABLE ) {

                this.stop();

                pool.shutdown();

                for (ClientHandler cH :
                        clientHandlerHashMap.values()) {
                    cH.closeHandler();
                }
                server.stop();
                server.close();
                closed = true;
            }
        }
    }

    public NetWork getNetWork() {
        return netWork;
    }

    public Server getServer() {
        return server;
    }

    public HashMap<InetAddress, ClientHandler> getClientHandlerHashMap() {
        return clientHandlerHashMap;
    }
}
