package ch.heigvd.amt.project.business;

import ch.heigvd.amt.project.model.Film;

import java.util.ArrayList;
import java.util.List;


public class FilmsList {
    private static final List<Film> moviesList = new ArrayList<>();

    private FilmsList() {

    }

    static{
        moviesList.add(Film.builder().id(0).title("You've Got mail").runningTime(119).moviePosterPath("you've_got_mail_large.jpg").build());
        moviesList.add(Film.builder().id(1).title("The Butler").runningTime(132).moviePosterPath("the_butler_large.jpg").build());
        moviesList.add(Film.builder().id(2).title("Scarface").runningTime(170).moviePosterPath("scarface_large.jpg").build());
    }

    public static List <Film> getInstance(){
        return moviesList;
    }
}