package Model;

import mp3agic.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.Objects;
import javax.swing.*;
import static javax.swing.JOptionPane.*;



public class Music extends Media {

    private String title = '<' + super.getFile().getName() + "\b\b\b\b" + '>';
    private Artist artist = Artist.unknown;
    private Album album = Album.unknown;
    private String  year = "<nothing>";
    private String comment = "<nothing>";
    private String track = "";
    private int genre;
    private byte[] imageAlbum;
    private int frames = 0;
    private long time = 0;

    private boolean favorite = false;
    private boolean shared = false;


    public Music(File mediaFile, LocalDateTime time) {
        super(mediaFile, time);
        loadMusic();
    }

    private static Object[] addMusic(Music music, String artist, String album) {
        Artist tempArtist = Artist.createArtist(artist);
        Album tempAlbum = tempArtist.createAlbum(album);
        tempAlbum.getMusics().add(music);

        return new Object[]{tempArtist, tempAlbum};
    }

    private void loadMusic() {
        try {
            this.getID3v1();
            this.getID3v2();
            imageAlbum = getArtWork();

        } catch (IOException e) {
            showMessageDialog(new JFrame(), "There is error in opening file",
                    "Error", ERROR_MESSAGE);
        } catch (UnsupportedTagException e) {
            Music.addMusic(this, artist.getName(), album.getName());
            showMessageDialog(new JFrame(), "This tag is not supported",
                    "Error", ERROR_MESSAGE);
        } catch (InvalidDataException e) {
            showMessageDialog(new JFrame(), "The format is not valid",
                    "Error", ERROR_MESSAGE);
        } catch (NullPointerException e) {
            Music.addMusic(this, artist.getName(), album.getName());
            showMessageDialog(new JFrame(), "The file doesn't have id3v1",
                    "Error", ERROR_MESSAGE);
        }
    }

    public byte[] getImageAlbum() {
        return imageAlbum;
    }

    public String getTitle() { return title; }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
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

    public boolean isFavorite() {
        return favorite;
    }

    public boolean isShared() {
        return shared;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    private void getID3v1() throws InvalidDataException, IOException, UnsupportedTagException {
        ID3v1 id3v1 = (new Mp3File(getFile().getPath())).getId3v1Tag();
        title = id3v1.getTitle();

        Object[] artistAndAlbum = Music.addMusic(this, id3v1.getArtist(), id3v1.getAlbum());
        artist = (Artist) artistAndAlbum[0];
        album = (Album) artistAndAlbum[1];

        comment = id3v1.getComment();
        year = id3v1.getYear();
        track = id3v1.getTrack();
        genre = id3v1.getGenre();
    }

    private void getID3v2() throws InvalidDataException, IOException, UnsupportedTagException {
        Mp3File mp3File = new Mp3File(getFile().getPath());
        time = mp3File.getLengthInSeconds();
        frames = mp3File.getFrameCount();
    }

    private byte[] getArtWork() throws InvalidDataException, IOException, UnsupportedTagException {

        Mp3File mp3File = new Mp3File(getFile().getPath());
        if ( mp3File.hasId3v2Tag() ) {

            byte[] imageBuffer = mp3File.getId3v2Tag().getAlbumImage();

            if ( imageBuffer != null ) {
                return imageBuffer;
            }
        }

        return new byte[0];
    }

    public void remove() {
        Artist.getArtists().remove(this.getArtist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, album);
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        int second = (int) time % 60;
        int minute = (int) (( time - second) / 60) % 60;
        int hour = (int) (time - second - minute * 60) /3600;
        if ( hour == 0 ) {
            formatter.format("%02d : %02d", minute, second);
        } else {
            formatter.format("%02d : %02d : %20d", hour, minute, second);
        }
        return "Title : " + title + '\n' +
                artist + '\n' +
                album + '\n' +
                "Year : " + year + '\n' +
                "Comment :" + comment + '\n' +
                "Track : " + track + '\n' +
                "Time : " + formatter;
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


//        private void getID3v1_2() throws IOException {
//
//        byte[] buffer = new byte[125];
//        RandomAccessFile file = new RandomAccessFile(super.getFile(), "r");
//        file.seek(file.length() - 125);
//
//        if (file.read(buffer,0,125) != 125 ) {
//            file.close();
//            throw new IOException();
//        }
//
//        String details = new String(buffer,0,125);
//        title = details.substring(0, 30).trim();
//        artist = new Artist(details.substring(30, 60).trim());
//        album = new Album(details.substring(60, 90).trim(), artist);
//        year = details.substring(90, 94).trim();
//        comment = details.substring(94,122).trim();
//        if ( comment.length() == 30 || comment.length() == 29) {
//            comment = details.substring(94, 124);
//        } else {
//            if ( buffer[122] == 0 ){
//
//                track = "" + (int) buffer[123];
//            }
//        }
//        genre = (int) details.charAt(124);
//
//    }
}
