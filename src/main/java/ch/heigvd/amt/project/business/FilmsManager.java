package ch.heigvd.amt.project.business;

import ch.heigvd.amt.project.model.Film;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class FilmsManager implements FilmsManagerLocal {

    private final List<Film> library = new LinkedList<>();

    public FilmsManager() {
        library.add(Film.builder().id(0).title("You've Got mail").runningTime(119).moviePosterPath("you've_got_mail.jpg").build());
        library.add(Film.builder().id(1).title("The Butler").runningTime(132).moviePosterPath("the_butler.jpg").build());
        library.add(Film.builder().id(2).title("Scarface").runningTime(170).moviePosterPath("scarface.jpg").build());
        library.add(Film.builder().id(3).title("Forest Gump").runningTime(142).moviePosterPath("forest_gump.jpg").build());
        library.add(Film.builder().id(4).title("Fight Club").runningTime(119).moviePosterPath("fight_club.jpg").build());
        library.add(Film.builder().id(5).title("The Lion King").runningTime(118).moviePosterPath("the_lion_king.jpg").build());
        library.add(Film.builder().id(6).title("Spider-Man: Into the Spider-Verse").runningTime(117).moviePosterPath("spider_man.jpg").build());
        library.add(Film.builder().id(7).title("Avengers: Endgame").runningTime(181).moviePosterPath("avengers_endgame.jpg").build());
        library.add(Film.builder().id(8).title("Joker").runningTime(122).moviePosterPath("joker.jpg").build());
        library.add(Film.builder().id(9).title("Star Wars: The Rise of Skywalker").runningTime(155).moviePosterPath("star_wars.jpg").build());
    }

    @Override
    public List<Film> getAllFilms() {
        return library;
    }
}
