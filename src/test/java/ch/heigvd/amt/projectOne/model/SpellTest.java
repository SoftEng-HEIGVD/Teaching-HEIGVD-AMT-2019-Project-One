package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellTest {

    @Test
    void itShouldBePossibleToCreateSpell() {

        Spell spell1 = Spell.builder().cooldown(5).damage(10).range(20).description("This is spell 1").build();
        Spell spell2 = Spell.builder().cooldown(10).damage(20).range(20).description("This is spell 2").build();
        Spell spell3 = Spell.builder().cooldown(8).damage(30).range(20).description("This is spell 3").build();


        assertNotNull(spell1);
        assertNotNull(spell2);
        assertNotNull(spell3);


        assertEquals(5, spell1.getCooldown());
        assertEquals(10, spell1.getDamage());
        assertEquals(20, spell1.getRange());
        assertEquals("This is spell 1", spell1.getDescription());

        assertEquals(10, spell2.getCooldown());
        assertEquals(20, spell2.getDamage());
        assertEquals(20, spell2.getRange());
        assertEquals("This is spell 2", spell2.getDescription());

        assertEquals(8, spell3.getCooldown());
        assertEquals(30, spell3.getDamage());
        assertEquals(20, spell3.getRange());
        assertEquals("This is spell 3", spell3.getRange());


    }

}