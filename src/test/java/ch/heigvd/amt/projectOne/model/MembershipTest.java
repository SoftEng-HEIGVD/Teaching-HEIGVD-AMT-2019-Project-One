package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MembershipTest {

    private static Character character;
    private static Guild guild;


    @BeforeAll
    static void weShouldCreatGuildAndCharacter(){
        guild = Guild.builder().name("Bard").description("Musicians").build();
        character = Character.builder()
                .name("Tsimwi")
                .level(1)
                .health(100)
                .mana(100)
                .stamina(100)
                .mount(Mount.builder().name("Pegasus").speed(100).build())
                .myClass(Class.builder().name("Mage").build())
                .build();

        assertNotNull(guild);
        assertEquals("Bard", guild.getName());
        assertEquals("Musicians", guild.getDescription());
        assertNotNull(character);
        assertEquals("Tsimwi", character.getName());
        assertEquals(1, character.getLevel());
        assertEquals(100, character.getHealth());
        assertEquals(100, character.getMana());
        assertEquals(100, character.getStamina());
        assertEquals("Pegasus", character.getMount().getName());
        assertEquals(100, character.getMount().getSpeed());


    }

    @Test
    void itShouldBePossibleToCreateMembership() {
        Membership membership = Membership.builder().character(character).guild(guild).rank("Master").build();

        assertNotNull(membership);
        assertEquals("Tsimwi", membership.getCharacter().getName());
        assertEquals(1, membership.getCharacter().getLevel());
        assertEquals(100, membership.getCharacter().getHealth());
        assertEquals(100, membership.getCharacter().getMana());
        assertEquals(100, membership.getCharacter().getStamina());
        assertEquals("Pegasus", membership.getCharacter().getMount().getName());
        assertEquals(100, membership.getCharacter().getMount().getSpeed());

        assertEquals("Bard", membership.getGuild().getName());
        assertEquals("Musicians", membership.getGuild().getDescription());

        assertEquals("Master", membership.getRank());

    }

}