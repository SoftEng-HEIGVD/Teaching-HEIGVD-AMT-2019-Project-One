package ch.heig.amt.project.one.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Serie extends Entity {
    private String title;
    private String genre;
    private String producer;
    private int ageRestriction;
    private String synopsis;
}
