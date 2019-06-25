package Model;

public enum Command {
    GETSTATUS(0, "Get Status"), DOWNLOAD(1, "Download"),
    SHAREDLIST(2, "Shared List"), SHAREDMUSIC(3, "Shared Music");

    private int number;
    private String name;

    Command(int number, String name) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
