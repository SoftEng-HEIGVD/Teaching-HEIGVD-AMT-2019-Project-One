package ch.heigvd.amt.project.datastore;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Film;
import ch.heigvd.amt.project.model.Preference;
import ch.heigvd.amt.project.model.User;

import javax.ejb.Singleton;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

// TODO; finish
@Singleton
public class InMemoryDataStore implements IInMemoryDatastore {

  /*
   * We store users and notes in concurrent hashmaps, with values indexed
   * by unique ids (username for Users, id for Notes).
   *
   * In the methods, you will see that we clone objects (on the way in and out of the
   * data store). The reason is that we don't want a client to pass an object to the
   * data store (by reference), modify it on its side, and have an impact on the object
   * under the control of the data store. Since our Model objects are immutable, this
   * would not be strictly necessary.
   */
  ConcurrentHashMap<String, User> storeUsers = new ConcurrentHashMap<>();
  ConcurrentHashMap<Long, Film> storeFilms = new ConcurrentHashMap<>();
  ConcurrentHashMap<String, List<Film>> storePreferences = new ConcurrentHashMap<>();

  @Override
  public List<User> getAllUsers() {
    return storeUsers
      .values()
      .stream()
      .map(user -> {
        User clone = user.toBuilder().build();
        return clone;
      }).collect(Collectors.toList());
  }

  @Override
  public void insertUser(User user) throws DuplicateKeyException {
    if (storeUsers.get(user.getUsername()) != null) {
      throw new DuplicateKeyException("User with username " + user.getUsername() + " already exists.");
    }
    User clone = user.toBuilder().build();
    storeUsers.put(user.getUsername(), clone);
  }

  @Override
  public User loadUserByUsername(String username) throws KeyNotFoundException {
    User user = storeUsers.get(username);
    if (user == null) {
      throw new KeyNotFoundException("Could not find user " + username);
    }
    User clone = user.toBuilder().build();
    return clone;
  }

  @Override
  public void updateUser(User user) throws KeyNotFoundException {
    User storedUser = storeUsers.get(user.getUsername());
    if (storedUser == null) {
      throw new KeyNotFoundException("Could not find user wit username " + user.getUsername());
    }
    User clone = user.toBuilder().build();
    storeUsers.put(user.getUsername(), clone);
  }

  @Override
  public Film getFilmById(long filmId) throws KeyNotFoundException {
    Film film = storeFilms.get(filmId);
    if(film == null) {
      throw new KeyNotFoundException("Could not find film with id " + filmId);
    }
    return film;
  }

  @Override
  public List<Film> getAllFilms() {
    return null;
  }

  @Override
  public List<Film> getAllPreferencesByUser(String username) throws KeyNotFoundException {
    return null;
  }

  @Override
  public synchronized void insertPreference(String username, long filmId) throws KeyNotFoundException {
    if (storeUsers.get(username) == null) {
      throw new KeyNotFoundException("Could not find user " + username );
    }
    if (storeFilms.get(filmId) == null) {
      throw new KeyNotFoundException("Could not find film with id " + filmId);
    }
    User userStoredInDB = storeUsers.get(username).toBuilder().build();
    Film filmStoredInDB = storeFilms.get(filmId).toBuilder().build();
    Preference preference = Preference.builder().user(userStoredInDB)
            .film(filmStoredInDB)
            .build();

    List<Film> currentPreferences = storePreferences.get(username);
    if(currentPreferences == null) {
      // No preferences yet
      currentPreferences = new LinkedList<>();
    }
    currentPreferences.add(filmStoredInDB);
  }

  @Override
  public void deletePreference(String username, long filmId) throws KeyNotFoundException {

  }

}
