import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MakeImage  {



    public MakeImage(File musicFile) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(musicFile);

        ImageIO.write(bufferedImage, "jpg",
                new File("I:\\Amir.haf76's Files\\Univercity\\ProjectOfJava\\test.jpg") );
    }


}
