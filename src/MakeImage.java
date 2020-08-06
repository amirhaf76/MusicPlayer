import Model.Music;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MakeImage  {

    public MakeImage(Music music) throws IOException {

        InputStream in = new ByteArrayInputStream(music.getImageAlbum());
        BufferedImage bufferedImage = ImageIO.read(in);

        ImageIO.write(bufferedImage, "jpg",
                new File("test.jpg") );
    }


}
