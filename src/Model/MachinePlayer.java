package Model;


import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.IOException;
import java.io.InputStream;

public class MachinePlayer extends Player {

    private Bitstream bitstream;


    public MachinePlayer(InputStream stream) throws JavaLayerException, IOException {
        super(stream);
        bitstream = new Bitstream(stream);
    }


    public void skipMusic(int offset) throws JavaLayerException {
        boolean repeat = true;
        while (offset-- > 0 && repeat ) {
            repeat = skipFrame();
        }
    }


    private boolean skipFrame() throws JavaLayerException
    {
        Header h = bitstream.readFrame();
        if (h == null) return false;
        bitstream.closeFrame();
        return true;

    }

    public long findNumbersOfFrame() throws JavaLayerException {

        boolean ret = true;
        int size = 0;

        while ( ret ) {

            ret = skipFrame();
            size++;

        }

        return size;
    }



}
