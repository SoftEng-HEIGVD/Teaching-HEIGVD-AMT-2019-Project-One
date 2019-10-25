package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Spell {

    private int id;
    private int damage;
    private int cooldown;
    private int range;
    private String description;

}
