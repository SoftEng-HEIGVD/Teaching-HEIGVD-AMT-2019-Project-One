package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Class {

    private int id;
    private String name;
    private String weapon;
    private String armor;
    private LinkedList<Spell> spells;

    public Class(int id, String name, String weapon, String armor, LinkedList<Spell> spells) {
        this.id = id;
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.spells = spells;
    }

    public Class(int id, String name, String weapon, String armor) {
        this.id = id;
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.spells = null;
    }

}
