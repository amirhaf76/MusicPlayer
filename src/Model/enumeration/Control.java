package Model.enumeration;

public enum Control {
    PAUSE(0, "Pause"), PLAYING(1, "Playing"),STOP(2, "Stop"),
    NEXT(3, "Next"), PREVIOUS(4, "Previous"),
    NOTSTARTED(5, "NotStart"), FINISH(6, "Finish"),
    SKIP(7, "Skip"), SELECTMUSIC(8, "SelectMusic");


    private int state;
    private String name;

    Control(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
