package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.LinkedList;

@Builder
@Getter
@EqualsAndHashCode
public class Character {

    private String name;
    private int level;
    private int health;
    private int mana;
    private int stamina;

    private Mount mount;
    private Class myClass;
    private LinkedList<Membership> memberships;



}
