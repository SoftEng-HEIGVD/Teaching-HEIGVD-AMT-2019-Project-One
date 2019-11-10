package ch.heigvd.amt.project.business;

import ch.heigvd.amt.project.model.Film;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class FilmsManager implements FilmsManagerLocal {

    private final List<Film> library = new LinkedList<>();

    public FilmsManager() {
        library.add(Film.builder().id(1).title("The Butler").runningTime(132).moviePosterPath("the_butler.jpg").director("Lee Daniels").build());
        library.add(Film.builder().id(2).title("Scarface").runningTime(170).moviePosterPath("scarface.jpg").director("Brian De Palma").build());
        library.add(Film.builder().id(3).title("Forest Gump").runningTime(142).moviePosterPath("forest_gump.jpg").director("Robert Zemeckis").build());
        library.add(Film.builder().id(4).title("Fight Club").runningTime(119).moviePosterPath("fight_club.jpg").director("David Fincher").build());
        library.add(Film.builder().id(5).title("The Lion King").runningTime(118).moviePosterPath("the_lion_king.jpg").director("Jon Favreau").build());
        library.add(Film.builder().id(6).title("Spider-Man: Into the Spider-Verse").runningTime(117).moviePosterPath("spider_man.jpg").director("Bob Persichetti").build());
        library.add(Film.builder().id(7).title("Avengers: Endgame").runningTime(181).moviePosterPath("avengers_endgame.jpg").director("Anthony Russo").build());
        library.add(Film.builder().id(8).title("Joker").runningTime(122).moviePosterPath("joker.jpg").director("Todd Phillips").build());
        library.add(Film.builder().id(9).title("Star Wars: The Rise of Skywalker").runningTime(155).moviePosterPath("star_wars.jpg").director("J.J. Abrams").build());
        library.add(Film.builder().id(10).title("You've Got mail").runningTime(119).moviePosterPath("you've_got_mail.jpg").director("Nora Ephron").build());
    }

    @Override
    public List<Film> getAllFilms() {
        return library;
    }

    @Override
    public Film getFilm(int idFilm) {
        return library.get(idFilm);
    }
}
