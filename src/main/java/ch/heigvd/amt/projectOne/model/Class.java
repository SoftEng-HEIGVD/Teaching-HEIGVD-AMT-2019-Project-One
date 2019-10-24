package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.LinkedList;

@Builder
@Getter
@EqualsAndHashCode
public class Class {

    private int id;
    private String name;
    private LinkedList<Spell> spells;

    public Class(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Class(int id, String name, LinkedList<Spell> spells) {
        this.id = id;
        this.name = name;
        this.spells = spells;
    }
}
