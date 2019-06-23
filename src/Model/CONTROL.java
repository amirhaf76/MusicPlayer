package Model;

enum CONTROL {
    PAUSE(0, "Pause"), PLAYING(1, "Playing"),STOP(2, "Stop"),
    NEXT(3, "Next"), PREVIOUS(4, "Previous"),
    NOTSTARTED(5, "NotStart"), FINISH(6, "Finish"),
    ALWAYS(7, "Always"), ONECE( 8, "Once"), JUSTTHIS(9, "JustThis"),
    SKIP(10, "Skip");


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
