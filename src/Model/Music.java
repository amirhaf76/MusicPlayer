package Model;

import mp3agic.*;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.Objects;


public class Music extends Media {

    // identification of Music
    private String title = "<nothing>";
    private Artist artist = new Artist("<nothing>");
    private Album album = new Album("<nothing>",artist);
    private String  year = "<nothing>";
    private String comment = "<nothing>";
    private String track = "";
    private int genre = 0;
    private byte[] imageAlbum;
    private long frames = 0;
    private long length = 0;

    private boolean favorite = false;
    private boolean sharedMusic = false;




    public Music(LocalDateTime joinedTime, File file) {
        super(file, joinedTime);
    }

    private void loadMusic() {
        try {
            Mp3File mp3File = new Mp3File(super.getFile());
            getArtWork(mp3File);
            getId3v1(mp3File);

            frames = mp3File.getFrameCount();
            length = mp3File.getLengthInMilliseconds();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

    }


    private void getArtWork(Mp3File mp3File) {
        ID3v2 id3v2 = mp3File.getId3v2Tag();
        imageAlbum = id3v2.getAlbumImage();
    }

    private void getId3v1(Mp3File mp3File) {
        ID3v1 id3v1 = mp3File.getId3v1Tag();
        title = id3v1.getTitle();
        artist = new Artist(id3v1.getArtist());
        album = new Album(id3v1.getAlbum(), artist);
        year = id3v1.getYear();
        comment = id3v1.getComment();
        track = id3v1.getTrack();
        genre = id3v1.getGenre();
    }


    public String getTitle() {
        return title;
    }

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

    public byte[] getImageAlbum() {
        return imageAlbum;
    }

    public long getFrames() {
        return frames;
    }

    public long getLength() {
        return length;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public boolean isSharedMusic() {
        return sharedMusic;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setSharedMusic(boolean sharedMusic) {
        this.sharedMusic = sharedMusic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Music music = (Music) o;
        return title.equals(music.title) &&
                artist.equals(music.artist) &&
                album.equals(music.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, artist, album);
    }

    @Override
    public String toString() {
        long second = length % 60;
        long minute = ((length - second) / 60) % 60;
        long hour = (length - second - 60 * minute) / 3600;

        Formatter formatter = new Formatter();

        if ( hour == 0 ) {
            formatter.format("%02d : %02d", minute, second);
        } else {
            formatter.format("%02d : %02d : %02d", hour, minute, second);
        }
        return "Title : " + title + '\n' +
                artist + '\n' +
                album + '\n' +
                "Year : " + year + '\n' +
                "Comment :" + comment + '\n' +
                "Track : " + track + '\n' +
                "Time : " + formatter;
    }
}
