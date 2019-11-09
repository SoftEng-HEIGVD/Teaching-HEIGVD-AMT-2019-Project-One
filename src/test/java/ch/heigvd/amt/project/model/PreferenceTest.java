package ch.heigvd.amt.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PreferenceTest {

    @Test
    void itShouldBePossibleToCreatePreferences() {
        User john = User.builder()
                .username("John_Doe")
                .firstName("John")
                .lastName("Doe")
                .email("John.Doe@email.com")
                .password("mypassword")
                .build();

        Film movie = new Film.FilmBuilder()
                .id(0)
                .title("The Reckoning")
                .build();

        Preference preference = new Preference.PreferenceBuilder()
                .user(john)
                .film(movie)
                .build();

        assertNotNull(preference);
        assertEquals(movie, preference.getFilm());
        assertEquals(john, preference.getUser());
    }
}
