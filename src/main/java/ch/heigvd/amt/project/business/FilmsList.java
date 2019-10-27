package ch.heigvd.amt.project.business;

import ch.heigvd.amt.project.model.Film;

import java.util.ArrayList;
import java.util.List;


public class FilmsList {
    private static final List<Film> moviesList = new ArrayList<>();

    private FilmsList(){
        moviesList.add(Film.builder().id(0).title("You've Got mail").build());
        moviesList.add(Film.builder().id(1).title("The Butler").build());
        moviesList.add(Film.builder().id(2).title("Scarface").build());
    }

    static{

    }

    public static List <Film> getInstance(){
        return moviesList;
    }
}