package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellTest {

    @Test
    void itShouldBePossibleToCreateSpell() {

        Spell spellStorm = Spell.builder().type(spellType.STORM).cooldown(5).damage(10).range(20).build();
        Spell spellFire = Spell.builder().type(spellType.FIRE).cooldown(10).damage(20).range(20).build();
        Spell spellIce = Spell.builder().type(spellType.ICE).cooldown(8).damage(30).range(20).build();
        Spell spellHearth = Spell.builder().type(spellType.HEARTH).cooldown(4).damage(40).range(20).build();
        Spell spellWind = Spell.builder().type(spellType.WIND).cooldown(9).damage(50).range(20).build();

        assertNotNull(spellStorm);
        assertNotNull(spellFire);
        assertNotNull(spellIce);
        assertNotNull(spellHearth);
        assertNotNull(spellWind);

        assertEquals(5, spellStorm.getCooldown());
        assertEquals(10, spellStorm.getDamage());
        assertEquals(20, spellStorm.getRange());

        assertEquals(10, spellFire.getCooldown());
        assertEquals(20, spellFire.getDamage());
        assertEquals(20, spellFire.getRange());

        assertEquals(8, spellIce.getCooldown());
        assertEquals(30, spellIce.getDamage());
        assertEquals(20, spellIce.getRange());

        assertEquals(4, spellHearth.getCooldown());
        assertEquals(40, spellHearth.getDamage());
        assertEquals(20, spellHearth.getRange());

        assertEquals(9, spellWind.getCooldown());
        assertEquals(50, spellWind.getDamage());
        assertEquals(20, spellWind.getRange());

    }

}