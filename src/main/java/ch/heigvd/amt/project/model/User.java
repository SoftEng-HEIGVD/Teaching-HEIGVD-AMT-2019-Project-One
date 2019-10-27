package ch.heigvd.amt.project.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}
