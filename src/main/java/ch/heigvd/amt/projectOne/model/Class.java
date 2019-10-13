package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.LinkedList;

@Builder
@Getter
@EqualsAndHashCode
public class Class {

    private String name;
    private LinkedList<Spell> spells;


}
