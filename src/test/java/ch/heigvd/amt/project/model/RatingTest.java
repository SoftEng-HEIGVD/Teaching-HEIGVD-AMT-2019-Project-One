package ch.heigvd.amt.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RatingTest {

    @Test
    void itShouldBePossibleToCreateUsers() {
        User john = User.builder()
                .id(0)
                .firstName("John")
                .lastName("Doe")
                .email("John.Doe@email.com")
                .password("mypassword")
                .build();

        Film movie = new Film.FilmBuilder()
                .id(0)
                .title("The Reckoning")
                .build();

        Rating rating = new Rating.RatingBuilder()
                .user(john)
                .film(movie)
                .rating(0)
                .build();

        assertNotNull(rating);
        assertEquals(movie, rating.getFilm());
        assertEquals(john, rating.getUser());
    }
}
