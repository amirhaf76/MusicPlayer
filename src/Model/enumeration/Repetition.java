package Model.enumeration;

import java.io.Serializable;

public enum Repetition implements Serializable {
    ALWAYS(7, "Always"), ONCE( 8, "Once"), JUSTTHIS(9, "JustThis");

    private int value;
    private String name;

    Repetition(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
