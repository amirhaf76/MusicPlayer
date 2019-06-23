package Model;

import mp3agic.*;
import java.io.*;
import java.sql.Time;
import java.util.Objects;


public class Music extends Media {

//    private final File mediaFile;

    private String title = "<nothing>";
    private String artist = "<nothing>";
    private String album = "<nothing>";
    private String  year = "<nothing>";
    private String comment = "<nothing>";
    private String track = "";
    private int genre;
    private byte[] imageAlbum;
    private int frames = 0;
    private long time = 0;


    public Music(File mediaFile, Time time) throws IOException, InvalidDataException, UnsupportedTagException {
        super(mediaFile, time);
        this.getID3v1();
        this.getID3v2();
        imageAlbum = getArtWork();
    }

    private void getID3v1_2() throws IOException, InvalidDataException, UnsupportedTagException {

        byte[] buffer = new byte[125];
        RandomAccessFile file = new RandomAccessFile(super.getMediaFile(), "r");
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

    }

    private void getID3v1() throws InvalidDataException, IOException, UnsupportedTagException {
        ID3v1 id3v1 = (new Mp3File(getMediaFile().getPath())).getId3v1Tag();
        title = id3v1.getTitle();
        artist = id3v1.getArtist();
        album = id3v1.getAlbum();
        comment = id3v1.getComment();
        year = id3v1.getYear();
        track = id3v1.getTrack();
        genre = id3v1.getGenre();


    }

    private void getID3v2() throws InvalidDataException, IOException, UnsupportedTagException {
        Mp3File mp3File = new Mp3File(getMediaFile().getPath());
        time = mp3File.getLengthInSeconds();
        frames = mp3File.getFrameCount();
    }

    private byte[] getArtWork() throws InvalidDataException, IOException, UnsupportedTagException {

        Mp3File mp3File = new Mp3File(getMediaFile().getPath());
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

    public int getFrames() {
        return frames;
    }

    public long getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return title.equals(music.title) &&
                artist.equals(music.artist) &&
                album.equals(music.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, album);
    }
}
