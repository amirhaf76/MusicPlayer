package Model;

import mp3agic.ID3v2;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Music extends Media {

    private final File musicFile;

    public Music(File musicFile) {
        this.musicFile = musicFile;
    }

    public void getArtWork() throws InvalidDataException, IOException, UnsupportedTagException {

        Mp3File mp3File = new Mp3File(musicFile.getPath());
        if ( mp3File.hasId3v2Tag() ) {

            byte[] imageBuffer = mp3File.getId3v2Tag().getAlbumImage();

            if ( imageBuffer != null ) {
                String temp = mp3File.getId3v2Tag().getAlbumImageMimeType();
                RandomAccessFile file = new RandomAccessFile("Album_artWork", "rw");
                file.write(temp.getBytes());
                file.close();

            }
        }
    }
}
