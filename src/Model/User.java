package Model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private transient Library library;

    private static final long serialVersionUID = 1398441L;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
