import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadArtWork {
    private FileReader reader;

    public ReadArtWork() {
        try {
            reader = new FileReader("Album_artWork");
            Scanner input = new Scanner(reader);

            while ( input.hasNext() ) {
                System.out.println(input.nextLine());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
