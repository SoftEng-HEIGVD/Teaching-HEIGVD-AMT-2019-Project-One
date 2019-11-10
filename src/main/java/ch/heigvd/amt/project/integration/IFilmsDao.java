package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Film;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IFilmsDao extends IDAO<String, Film> {
    List<Film> findBetween(String id1, String id2) throws KeyNotFoundException;
}
