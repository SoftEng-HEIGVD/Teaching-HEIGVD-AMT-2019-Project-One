package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.LinkedList;

@Builder
@Getter
@EqualsAndHashCode
public class Character {

    private int id;
    private String name;
    private int level;
    private int health;
    private int stamina;
    private int mana;

    private Mount mount;
    private Class myClass;
    private LinkedList<Membership> memberships;


    public Character(int id, String name, int level, int health, int stamina, int mana) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.stamina = stamina;
        this.mana = mana;
    }

    public Character(int id, String name, int level, int health, int stamina, int mana, Mount mount, Class myClass, LinkedList<Membership> memberships) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.stamina = stamina;
        this.mana = mana;
        this.mount = mount;
        this.myClass = myClass;
        this.memberships = memberships;
    }
}
