package Model;


import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.*;
import java.io.InputStream;

public class MachinePlayer extends Player {

    private Bitstream bitstream;


    public MachinePlayer(InputStream stream) throws JavaLayerException {
        super(stream);
        bitstream = new Bitstream(stream);
    }

    public void skipMusicBasedOnFrame(int offset) {
        boolean repeat = true;
        while (offset-- > 0 && repeat ) {
            try {
                repeat = skipFrame();
            } catch (JavaLayerException e) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "Error in frame working","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean skipFrame() throws JavaLayerException {
        Header h = bitstream.readFrame();
        if (h == null) return false;
        bitstream.closeFrame();
        return true;
    }


}
