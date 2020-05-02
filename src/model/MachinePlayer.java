package model;

import model.enumeration.Command;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.*;
import java.io.InputStream;
import static javax.swing.JOptionPane.*;
import static model.enumeration.Command.*;

public class MachinePlayer extends Player {

    private Bitstream bitstream;
    private int frameNumber = 0;
    private Command state = READY;

    private final Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while ( state.equals(PLAYING) ) {
                try {
                    if ( MachinePlayer.super.play(1))
                        frameNumber++;
                    else {
                        state = FINISHED;
                        break;
                    }

                    synchronized (runner) {
                        if ( state.equals(PAUSE) )
                            runner.wait();
                    }

                } catch (JavaLayerException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    showMessageDialog(null,
                            "Error in MachinePlayer. The Player is interrupted.","Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });

    public MachinePlayer(InputStream stream) throws JavaLayerException {
        super(stream);
        bitstream = new Bitstream(stream);
    }

    public void skipMusicBasedOnFrame(int offset) {
        boolean repeat = true;
        while (offset-- > 0 && repeat ) {
            frameNumber++;
            try {
                repeat = skipFrame();
            } catch (JavaLayerException e) {
                showMessageDialog(null,
                    "Error in frame working","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void stop() {
        synchronized (runner) {
            state = STOP;
        }
    }

    public void pause() {
        synchronized (runner) {
            state = PAUSE;
        }
    }

    public void play() {
        synchronized (runner) {
            if ( state.equals(READY) || state.equals(STOP) || state.equals(FINISHED) ) {
                state = PLAYING;
                runMusic();
            }
            else if ( state.equals(PAUSE) ) {
                runner.notifyAll();
                state = PLAYING;
            }
        }
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public Command getState() {
        return state;
    }

    public void runMusic() {
        runner.setPriority(Thread.MAX_PRIORITY);
        runner.start();
    }


    public boolean skipFrame() throws JavaLayerException {
        Header h = bitstream.readFrame();
        if (h == null) return false;
        bitstream.closeFrame();
        return true;
    }

    public void close() {
        try {
            if (state == PLAYING )
                this.stop();

            bitstream.close();
        } catch (BitstreamException e) {
            e.printStackTrace();
        }
    }

}

