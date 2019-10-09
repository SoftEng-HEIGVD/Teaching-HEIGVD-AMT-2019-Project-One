package ch.heigvd.amt.livecoding.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
