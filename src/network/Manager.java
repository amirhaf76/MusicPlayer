package network;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager extends Thread {

    private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private ExecutorService pool = Executors.newFixedThreadPool(4);
    private boolean closed = false;

    @Override
    public void run() {

        while ( !closed ) {
            for (ClientHandler cH :
                    clientHandlers) {
                pool.execute(cH);
            }
        }

    }
}
