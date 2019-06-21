package Model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;


public class MusicController {

    private Player player;
    private BufferedInputStream buffer;

    private File musicFile;


    public MusicController(File musicFile) throws IOException, UnsupportedAudioFileException {
        this.musicFile = musicFile;

    }



    public void startMusic(long frame) throws IOException, JavaLayerException {
        playMusic();
    }

    private void playMusic() throws IOException, JavaLayerException {




        buffer = new BufferedInputStream(new FileInputStream(musicFile));
        player = new MachinePlayer(buffer);
        System.out.println( ((MachinePlayer)player).findTime());
        player.close();
        buffer.close();

        buffer = new BufferedInputStream(new FileInputStream(musicFile));
        player = new MachinePlayer(buffer);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {


                    ((MachinePlayer)player).skipMusic(0);
                    player.play();
                    System.out.println("end");


                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
