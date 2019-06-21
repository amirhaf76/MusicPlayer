package Model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;


public class MusicController {

    private File musicFile;
    private MachinePlayer player;

    private BufferedInputStream buffer;

    private long numberOfFrame;
    private int lastTime = 0;

    private Object lock = new Object(); // make player lock



    public MusicController(File musicFile) throws IOException, JavaLayerException {
        this.musicFile = musicFile;

        buffer = new BufferedInputStream(new FileInputStream(musicFile));
        player = new MachinePlayer(buffer);

        numberOfFrame = player.findNumbersOfFrame();

        player.close(); // close player and buffer

    }



    public void start(long frame) throws IOException, JavaLayerException {
        playMusic();
    }

    private void playMusic() throws IOException, JavaLayerException {

        buffer = new BufferedInputStream(new FileInputStream(musicFile));
        player = new MachinePlayer(buffer);

        Thread runPlayer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {


                    player.skipMusic(7800);
                    player.play();
                    System.out.println("end");


                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }, "Music player");

        runPlayer.start(); // if song reach to the end, player close buffer


    }

    public void resume() {

    }

    public void stop() {

    }

    public void next(File musicFile) {

    }

    public void previous() {

    }
}

enum CONTROL {
    PAUSE(0, "Pause"), RESUME(1, "Resume"), STOP(2, "Stop"),
    NEXT(3, "Next"), PREVIOUS(4, "Previous");

    private int state;
    private String name;

    CONTROL(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}