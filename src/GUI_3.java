

import Model.Jpotify;
import Model.Media;
import Model.Music;
import Model.User;
import mp3agic.InvalidDataException;
import mp3agic.UnsupportedTagException;
import storage.Storage;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FileChooserUI;
import java.io.File;
import java.io.IOException;
import java.sql.Time;

/**
 *
 * @author asus
 */
public class GUI_3 {

    public GUI_3(User user, Jpotify jpotify)
    {

        JFileChooser jFileChooser1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int val = jFileChooser1.showSaveDialog(null);
        FileFilter filter = new FileNameExtensionFilter("MP3 File","mp3");
        jFileChooser1.addChoosableFileFilter(filter);
        if(val ==jFileChooser1.APPROVE_OPTION)
        {
            File file = jFileChooser1.getSelectedFile();
            String adress = file.getAbsolutePath();
            Music music = null;
            try {
                System.out.println(file.getName());
                music = new Music(file,new Time(System.currentTimeMillis()));
            } catch (InvalidDataException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedTagException e) {
                e.printStackTrace();
            }

            user.getLibrary().addMediaToLibrary(music);
            try {
                Storage.saveJpotify(jpotify);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
