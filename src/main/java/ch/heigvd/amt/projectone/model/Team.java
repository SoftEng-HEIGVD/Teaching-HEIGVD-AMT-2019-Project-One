package ch.heigvd.amt.projectone.model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Builder
@Getter
public class Team {
    private String name;
    private String location;
    private Date dateCreation;
}
