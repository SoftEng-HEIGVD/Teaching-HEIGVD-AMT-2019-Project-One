package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Film;
import ch.heigvd.amt.project.model.Preference;

import javax.ejb.Local;
import java.util.List;

// TODO: do it here!
@Local
public interface IPreferencesDAO {

    Preference create(Preference preference) throws DuplicateKeyException;
    Preference findByKeys(long filmId, String username) throws KeyNotFoundException;
    void delete(Preference preference) throws KeyNotFoundException;
    List<Film> findAllByUsername(String username) throws KeyNotFoundException;
}
