package ch.heigvd.amt.project.business;

import ch.heigvd.amt.project.model.Film;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FilmsManagerLocal {

    /**
     * Get all films in the DB.
     * @return all films in the DB
     */
    List<Film> getAllFilms();
}
