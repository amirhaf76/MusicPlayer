package Model;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class Media implements Serializable {

   private final LocalDateTime joinedTime;
   private final File file;
   private LocalDateTime lastTimePlayed;


    public Media(File file, LocalDateTime joinedTime) {
        this.file = file;
        this.joinedTime = joinedTime;
    }

    public LocalDateTime getJoinedTime() {
        return joinedTime;
    }

    public File getFile() {
        return file;
    }

    public LocalDateTime getLastTimePlayed() {
        return lastTimePlayed;
    }

    public void setLastTimePlayed(LocalDateTime lastTimePlayed) {
        this.lastTimePlayed = lastTimePlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return file.equals(media.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file);
    }

    @Override
    public String toString() {
        return "Media{" +
                "joinedTime=" + joinedTime +
                ", file=" + file +
                ", lastTimePlayed=" + lastTimePlayed +
                '}';
    }
}
