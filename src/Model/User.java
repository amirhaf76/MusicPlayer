package Model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private Library library;

    private static final long serialVersionUID = 1398441L;



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
