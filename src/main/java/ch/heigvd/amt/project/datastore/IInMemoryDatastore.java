package ch.heigvd.amt.project.datastore;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Film;
import ch.heigvd.amt.project.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IInMemoryDatastore {

  List<User> getAllUsers();

  void insertUser(User user) throws DuplicateKeyException;

  User loadUserByUsername(String username) throws KeyNotFoundException;

  void updateUser(User user) throws KeyNotFoundException;

  Film getFilmById(long filmId) throws KeyNotFoundException;

  List<Film> getAllFilms();

  List<Film> getAllPreferencesByUser(String username) throws KeyNotFoundException;

  void insertPreference(String username, long filmId) throws KeyNotFoundException;

  void deletePreference(String username, long filmId) throws KeyNotFoundException;

}
