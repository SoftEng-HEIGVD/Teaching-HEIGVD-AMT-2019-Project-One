package ch.heigvd.amt.projectone.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Client {

    private int id;
    private String name;
    private String username;
    private String password;
}


