package network;

import Model.Music;
import Model.User;
import Model.enumeration.Command;
import storage.DownloadFile;
import storage.SaveDownload;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class ClientHandler implements Runnable {


    private final Socket client;
    private final User user;
    private final Manager manager;
    private final ObjectInputStream ois;
    private final ObjectOutputStream oos;

    private final Object lock = new Object();


    private volatile DownloadFile requestedMusic;

    private volatile SaveDownload newMusic;
    private volatile Music downloadMusic;

    private ArrayList<Command> commands = new ArrayList<>();


    public ClientHandler(User user, Socket client, Manager manager) throws IOException {
        this.user = user;
        this.client = client;
        this.ois = new ObjectInputStream(client.getInputStream());
        this.oos = new ObjectOutputStream(client.getOutputStream());
        this.manager = manager;
    }

    public void closeHandler() throws IOException {
        synchronized (lock) {
            ois.close();
            oos.close();
            client.close();
        }
    }

    public void downloadMusic(Music music) {
        synchronized (lock) {
            if ( downloadMusic == null ) {

                if ( !commands.contains(Command.DOWNLOAD) ) {
                    commands.add(Command.DOWNLOAD);
                }
                downloadMusic = music;
            }
        }
    }

    public void requestSharedMusic() {
        synchronized (lock) {
            if ( !commands.contains(Command.SHAREDMUSIC) ) {
                commands.add(Command.SHAREDMUSIC);
            }
        }
    }

    @Override
    public void run() {


        if ( !client.isClosed() ){

            try {
                Package receivedPackage;
                Package torturePackage;
                if (ois.available()>0) {
                    receivedPackage = (Package) ois.readObject();
                    // get data from package
                    if ( downloadMusic != null ) {
                        getDataFromPackage(receivedPackage);
                    }

                    // answer to command
                    torturePackage = answerToCommand(receivedPackage);

                    // send package
                    oos.writeObject(torturePackage);

                    oos.flush();
                }
                else if (requestedMusic != null ) {

                }

            } catch (IOException e) {
                manager.removeClientHandler(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }



    private Package answerToCommand(Package receivedPackage) throws IOException {
        synchronized (lock) {

            ArrayList<Music> requestedSharedMusic = new ArrayList<>();
            byte[] data = new byte[0];
            boolean end = true;

            for (Command c :
                    receivedPackage.getRequest()) {

                switch (c) {
                    case SHAREDMUSIC:
                        requestedSharedMusic = user.getLibrary().getSharedList().getMusic();
                        break;
                    case DOWNLOAD:
                        data = download(receivedPackage.getGetMusic());
                        end = data.length == 0;
                        break;
                }
            }

            return new Package(commands,
                    requestedSharedMusic,
                    downloadMusic, data, end);
        }
    }



    private byte[] download(Music music) throws IOException {
        // prepare file
        if ( requestedMusic == null ) {
            requestedMusic = new DownloadFile(music.getMediaFile());
            requestedMusic.prepareForSending();
        }

        if ( !requestedMusic.isEnd() ) {
            return requestedMusic.getPartOfData();
        }
        else {
            byte[] temp = requestedMusic.getPartOfData();
            requestedMusic = null;
            return temp;
        }
    }



    private void getDataFromPackage(Package receivedPackage) throws IOException {
        if ( newMusic == null ) {
            System.out.println(downloadMusic);
            newMusic = new SaveDownload(user.getName(),
                    downloadMusic.getMediaFile().getName());
        }

        if ( !receivedPackage.isEndDownload()) {
            newMusic.saveData(receivedPackage.getData());
        } else {
            newMusic.end();
            newMusic = null;
        }

    }

    public Socket getClient() {
        return client;
    }
}
