package network;

import model.Music;
import model.User;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import storage.DownloadFile;
import storage.SaveDownload;
import java.io.*;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;


public class ClientHandler implements Runnable {


    private final Socket client;
    private final User user;
    private final Manager manager;
    private final ObjectInputStream ois;
    private final ObjectOutputStream oos;

    private final Object lock = new Object();

    private ArrayList<Music> sharedList = new ArrayList<>();

    private volatile DownloadFile preparationOfRequestedMusic;
    private volatile Music requestedMusic;

    private volatile SaveDownload fileOfDownloadMusic;
    private volatile Music downloadMusic;




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
                downloadMusic = music;
            }
        }
    }

    public ArrayList<Music> getSharedList() {
        return sharedList;
    }

    public Socket getClient() {
        return client;
    }



    @Override
    public void run() {


        if ( !client.isClosed() ){
            synchronized (lock) {
                try {
                    Package receivedPackage;
                    Package torturePackage;

                    // check does anything received
                    if (ois.available()>0) {
                        receivedPackage = (Package) ois.readObject();

                        // extract package
                        extractPackage(receivedPackage);

                    }

                    // prepare package for sending
                    torturePackage = preparePackageForSending();
                    oos.writeObject(torturePackage);
                    oos.flush();


                } catch (IOException e) {
                    manager.removeClientHandler(this);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                } catch (UnsupportedTagException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private void extractPackage(Package receivedPackage) throws InvalidDataException, IOException, UnsupportedTagException {
        sharedList = receivedPackage.getSharedMusic();
        requestedMusic = receivedPackage.getGetMusic();
        getDataFromPackage(receivedPackage);
    }


    private Package preparePackageForSending() throws IOException {
        // sharedMusic
        ArrayList<Music> sharedMusic = user.getLibrary().getSharedList().getMusic();

        // download music
        Music temp = null;
        if ( downloadMusic != null) {
            temp = downloadMusic;
            downloadMusic = null;
        }

        // prepare data
        byte[] data = sendDataOfMusic();

        return new Package(sharedMusic, temp, data);

    }



    private byte[] sendDataOfMusic() throws IOException {

        if (requestedMusic != null ) {

            // prepare data of music for sending music (for first time)
            if ( preparationOfRequestedMusic == null ) {
                preparationOfRequestedMusic = new DownloadFile(requestedMusic.getMediaFile());
                preparationOfRequestedMusic.prepareForSending();
            }

            if ( !preparationOfRequestedMusic.isEnd() ) {
                return preparationOfRequestedMusic.getPartOfData();
            }
            else {
                requestedMusic = null;
                preparationOfRequestedMusic = null;
                return new byte[0];
            }
        }
        return new byte[0];
    }



    private void getDataFromPackage(Package receivedPackage) throws IOException, InvalidDataException, UnsupportedTagException {
        if ( downloadMusic != null ) {

            // prepare file for saving music (for first time)
            if ( fileOfDownloadMusic == null ) {
                fileOfDownloadMusic = new SaveDownload(user.getName(),
                        downloadMusic.getMediaFile().getName());
            }


            if ( receivedPackage.getData().length != 0 ) {
                fileOfDownloadMusic.saveData(receivedPackage.getData());
            } else {

                fileOfDownloadMusic.end();
                downloadMusic = null;

                // add to library
                user.getLibrary().addMediaToLibrary( new Music(fileOfDownloadMusic.getDownloadFile(),
                        new Time(System.currentTimeMillis())) );

                fileOfDownloadMusic = null;
            }
        }

    }
}
