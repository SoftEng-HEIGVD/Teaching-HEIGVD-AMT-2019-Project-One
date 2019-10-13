package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {

    private static LinkedList<Spell> spells = new LinkedList<Spell>();

    @BeforeAll
    static void weShouldPopulateSpells(){

        for(spellType type : spellType.values()){
            Spell spell = Spell.builder().type(type).cooldown(5).damage(50).range(20).build();

            spells.add(spell);
        }

    }


    @Test
    void itShouldBePossibleToCreateClass() {


        Class myclass = Class.builder()
                .name("Thief").spells(spells).build();

        assertNotNull(myclass);
        assertEquals("Thief", myclass.getName());
        assertEquals(spells, myclass.getSpells());

    }

}