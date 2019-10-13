package ch.heig.amt.project.one.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TestUser {
    @Test
    void itShouldBePossibleToCreateUsers() {
        // Declaration
        ArrayList<Entity> entities = new ArrayList<Entity>();
        // Assertions
        Entity serie1 = Serie.builder()
                .title("Game of Thrones")
                .genre("Drama")
                .producer("HBO")
                .ageRestriction(16)
                .synopsis("Jon Snow is badass")
                .build();
        Entity serie2 = Serie.builder()
                .title("Miami Vice")
                .genre("Cop")
                .producer("NBC")
                .ageRestriction(13)
                .synopsis("The white ferrari is so cool")
                .build();

        // Tests
        entities.add(Serie.builder()
                .title("Game of Thrones")
                .genre("Drama")
                .producer("HBO")
                .ageRestriction(16)
                .synopsis("Jon Snow is badass")
                .build());

        entities.add(Serie.builder()
                .title("Miami Vice")
                .genre("Cop")
                .producer("NBC")
                .ageRestriction(13)
                .synopsis("The white ferrari is so cool")
                .build());

        User user = User.builder()
            .username("admin")
            .password("admin2019")
            .entities(entities)
                .build();

        assertNotNull(user);
        assertEquals("admin", user.getUsername());
        assertEquals("admin2019", user.getPassword());
        assertEquals(serie1, entities.get(0));
        assertEquals(serie2, entities.get(1));
    }
}
