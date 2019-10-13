package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GuildTest {

    @Test
    void itShouldBePossibleToCreateGuild() {
        Guild bestGuild = Guild.builder().name("Bard").description("Musicians").build();

        assertNotNull(bestGuild);
        assertEquals("Bard", bestGuild.getName());
        assertEquals("Musicians", bestGuild.getDescription());

    }
}