package ch.heigvd.amt.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FilmTest {

    @Test
    void itShouldBePossibleToCreateFilms() {
        Film movie = new Film.FilmBuilder()
                .id(0)
                .title("The Reckoning")
                .build();

        assertNotNull(movie);

        assertEquals(0, movie.getId());
        assertEquals("The Reckoning", movie.getTitle());

    }

}
