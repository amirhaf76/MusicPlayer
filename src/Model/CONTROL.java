package Model;

enum CONTROL {
    PAUSE(0, "Pause"), PLAYING(1, "Playing"),STOP(2, "Stop"),
    NEXT(3, "Next"), PREVIOUS(4, "Previous"),
    NOTSTARTED(5, "NotStart"),
    ALWAYS(6, "Always"), ONECE( 7, "Once"), JUSTTHIS(8, "JustThis");

    private int state;
    private String name;

    CONTROL(int state, String name) {
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
