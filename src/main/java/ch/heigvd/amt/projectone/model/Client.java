package ch.heigvd.amt.projectone.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@EqualsAndHashCode
@Getter
public class Client {

    private int id;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;

    public Client(int id, String name, String username, String password, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Client(String name, String username, String password) {
        this(-1,name,username,password,false);
    }
}


