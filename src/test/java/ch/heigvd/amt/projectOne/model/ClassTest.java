package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {

    private static LinkedList<Spell> spells = new LinkedList<Spell>();

    @BeforeAll
    static void weShouldPopulateSpells(){

        Spell spell1 = Spell.builder().cooldown(5).damage(10).range(20).description("This is spell 1").build();
        Spell spell2 = Spell.builder().cooldown(10).damage(20).range(20).description("This is spell 2").build();
        Spell spell3 = Spell.builder().cooldown(8).damage(30).range(20).description("This is spell 3").build();

            spells.add(spell1);
            spells.add(spell2);
            spells.add(spell3);

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