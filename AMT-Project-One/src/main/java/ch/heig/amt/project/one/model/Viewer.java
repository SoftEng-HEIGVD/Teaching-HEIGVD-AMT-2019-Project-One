package ch.heig.amt.project.one.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Viewer extends Entity {
    private String firstname;
    private String lastname;
    private String username;
    private String genre;
    private Date birthDate;
}
