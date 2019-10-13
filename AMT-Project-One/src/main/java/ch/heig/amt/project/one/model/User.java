package ch.heig.amt.project.one.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String username;
    private String password;
    private ArrayList<Entity> entities;
}
