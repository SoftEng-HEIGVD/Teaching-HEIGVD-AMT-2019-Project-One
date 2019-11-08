package ch.heigvd.amt.projectone.model;

public class Client {

    private int id;
    private String name;
    private String username;
    private String password;

    public Client() {
    }

    public Client(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}


