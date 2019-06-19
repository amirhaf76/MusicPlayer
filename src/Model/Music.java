package Model;

import mp3agic.*;
import java.io.*;


public class Music extends Media {

    private final File musicFile;

    private String title;
    private String artist;
    private String album;
    private String  year;
    private String comment;
    private String track = "";
    private int genre;
    private byte[] imageAlbum;

    public Music(File musicFile) throws IOException, InvalidDataException, UnsupportedTagException {
        this.musicFile = musicFile;
        getID3v1();
    }

    private void getID3v1_2() throws IOException, InvalidDataException, UnsupportedTagException {

        byte[] buffer = new byte[125];
        RandomAccessFile file = new RandomAccessFile(musicFile, "r");
        file.seek(file.length() - 125);

        if (file.read(buffer,0,125) != 125 ) {
            file.close();
            throw new IOException();
        }

        String details = new String(buffer,0,125);
        title = details.substring(0, 30).trim();
        artist = details.substring(30, 60).trim();
        album = details.substring(60, 90).trim();
        year = details.substring(90, 94).trim();
        comment = details.substring(94,122).trim();
        if ( comment.length() == 30 || comment.length() == 29) {
            comment = details.substring(94, 124);
        } else {
            if ( buffer[122] == 0 ){

                track = "" + (int) buffer[123];
            }
        }
        genre = (int) details.charAt(124);
        imageAlbum = getArtWork();
    }

    private void getID3v1() throws InvalidDataException, IOException, UnsupportedTagException {
        ID3v1 id3v1 = (new Mp3File(musicFile.getPath())).getId3v1Tag();
        title = id3v1.getTitle();
        artist = id3v1.getArtist();
        album = id3v1.getAlbum();
        comment = id3v1.getComment();
        year = id3v1.getYear();
        track = id3v1.getTrack();
        genre = id3v1.getGenre();
        imageAlbum = getArtWork();
    }

    private byte[] getArtWork() throws InvalidDataException, IOException, UnsupportedTagException {

        Mp3File mp3File = new Mp3File(musicFile.getPath());
        if ( mp3File.hasId3v2Tag() ) {

            byte[] imageBuffer = mp3File.getId3v2Tag().getAlbumImage();

            if ( imageBuffer != null ) {
                return imageBuffer;
            }
        }

        return new byte[0];
    }

    public byte[] getImageAlbum() {
        return imageAlbum;
    }

    public File getMusicFile() {
        return musicFile;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getYear() {
        return year;
    }

    public String getComment() {
        return comment;
    }

    public String getTrack() {
        return track;
    }

    public int getGenre() {
        return genre;
    }
}
