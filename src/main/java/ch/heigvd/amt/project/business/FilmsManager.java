package ch.heigvd.amt.project.business;

import ch.heigvd.amt.project.model.Film;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class FilmsManager implements FilmsManagerLocal {

    private final List<Film> library = new LinkedList<>();

    public FilmsManager() {
        library.add(Film.builder().id(0).title("You've Got mail").runningTime(119).moviePosterPath("you've_got_mail_large.jpg").build());
        library.add(Film.builder().id(1).title("The Butler").runningTime(132).moviePosterPath("the_butler_large.jpg").build());
        library.add(Film.builder().id(2).title("Scarface").runningTime(170).moviePosterPath("scarface_large.jpg").build());
    }

    @Override
    public List<Film> getAllFilms() {
        return library;
    }
}
