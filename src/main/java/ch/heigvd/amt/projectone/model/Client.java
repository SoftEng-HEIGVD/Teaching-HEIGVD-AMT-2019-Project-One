package ch.heigvd.amt.projectone.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Client {

    private int id;
    private String name;
    private String username;
    private String password;

    public Client(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
