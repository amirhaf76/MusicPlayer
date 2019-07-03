package Model;


import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.InputStream;
import java.io.Serializable;

public class MachinePlayer extends Player implements Serializable {

    private Bitstream bitstream;


    public MachinePlayer(InputStream stream) throws JavaLayerException {
        super(stream);
        bitstream = new Bitstream(stream);
    }

    public void skipMusicBasedOnFrame(int offset) throws JavaLayerException {
        boolean repeat = true;
        while (offset-- > 0 && repeat ) {
            repeat = skipFrame();
        }
    }

    private boolean skipFrame() throws JavaLayerException {
        Header h = bitstream.readFrame();
        if (h == null) return false;
        bitstream.closeFrame();
        return true;
    }

}
