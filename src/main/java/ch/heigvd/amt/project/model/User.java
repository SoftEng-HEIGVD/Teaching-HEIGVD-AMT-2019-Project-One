package ch.heigvd.amt.project.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
public class User {
    // TODO: admin User
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}
