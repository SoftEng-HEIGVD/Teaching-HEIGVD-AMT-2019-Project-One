package ch.heig.amt.project.one.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Viewer extends Entity {
    private String firstname;
    private String lastname;
    private String username;
    private Date birthDate;
    private ArrayList<WatchingInfo> watchingInfos;
}
