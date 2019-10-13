package ch.heig.amt.project.one.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSerie {
    @Test
    void itShouldBePossibleToCreateSeries() {
        Serie got = Serie.builder()
                .title("Game of Thrones")
                .genre("Drama")
                .producer("HBO")
                .ageRestriction(16)
                .synopsis("Jon Snow is badass")
                .build();
        got.setId(1);

        assertNotNull(got);
        assertEquals(1, got.getId());
        assertEquals("Game of Thrones", got.getTitle());
        assertEquals("Drama", got.getGenre());
        assertEquals("HBO", got.getProducer());
        assertEquals(16, got.getAgeRestriction());
        assertEquals("Jon Snow is badass", got.getSynopsis());
    }
}
