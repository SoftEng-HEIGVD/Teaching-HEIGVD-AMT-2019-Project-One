package ch.heigvd.amt.projectone.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Person {

    private String name;
    private String username;
    private String password;

    Person(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
