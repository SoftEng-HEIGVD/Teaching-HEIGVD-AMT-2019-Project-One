package ch.heig.amt.project.one.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String username;
    private String password;
    private ArrayList<Entity> entities;
}
