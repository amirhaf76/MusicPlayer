package Model;


import network.NetWork;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class User implements Serializable {

    private String name;
    private String password;
    private InetAddress ip;

    private transient Library library = new Library();
    private transient NetWork netWork;

    private ArrayList<InetAddress> friends = new ArrayList<>();



    private static final long serialVersionUID = 1398441L;

    public User(String name, String password) throws IOException {
        this.name = name;
        this.password = password;
        netWork = new NetWork(this);
    }

    public String getName() {
        return name;
    }

    public NetWork getNetWork() {
        return netWork;
    }

    public boolean canPass(String password) {
        return this.password.equals(password);
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void addFriend(InetAddress ip) {
        friends.add(ip);
    }

    public void removeFriend(InetAddress ip) {
        friends.remove(ip);
    }

    public ArrayList<InetAddress> getFriends() {
        return friends;
    }
}
