package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Spell {

    private spellType type;
    private int damage;
    private int cooldown;
    private int range;

}
