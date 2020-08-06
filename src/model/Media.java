package model;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Media implements Serializable {

    private final File file;
    private LocalDateTime joinedTime;
    private LocalDateTime lastTime;
    private static final long serialVersionUID = 139864L;
    public Media(File file, LocalDateTime joinedTime) {
        this.file = file;
        this.joinedTime = joinedTime;
    }

    public String getName() {
        if ( this instanceof Music ) {
            return ((Music)this).getTitle();
        }
        return "<it's not Music>";
    }

    public File getFile() {
        return file;
    }

    public LocalDateTime getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(LocalDateTime joinedTime) {
        this.joinedTime = joinedTime;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
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
}
