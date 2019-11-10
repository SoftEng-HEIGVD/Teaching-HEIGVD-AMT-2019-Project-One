package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Film;
import ch.heigvd.amt.project.model.Preference;
import ch.heigvd.amt.project.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

// TODO:  save Error messages
@Stateless
public class PreferencesDAO implements IPreferencesDAO {

    // For Payara (see http://mjremijan.blogspot.com/2015/11/payaraglassfish-datasource-reference.html)
    @Resource(lookup = "jdbc/film_library")
    DataSource dataSource;

    // For Wildfly (see https://docs.jboss.org/author/display/WFLY10/JNDI+Reference)
    //@Resource(lookup = "java:/jdbc/film_library")
    //DataSource dataSource;

    @Override
    public Preference create(Preference preference) throws DuplicateKeyException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO amt_preferences (FILM_ID, USERNAME) VALUES (?,?)");
            statement.setString(1, String.valueOf(preference.getFilm().getId()));
            statement.setString(2, preference.getUser().getUsername());
            statement.execute();
            return preference;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Preference findByKeys(long filmId, String username) throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM amt_files WHERE FILM_ID=? AND USERNAME=?");
            statement.setString(1, String.valueOf(filmId));
            statement.setString(2, username);
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if(!hasRecord) {
                throw new KeyNotFoundException("Could not find Prefenrece with film_id " + filmId + " for user " + username);
            }

            FilmsDAO filmsDAO = new FilmsDAO();
            UsersDAO usersDAO = new UsersDAO();
            Film film = filmsDAO.findById(rs.getString("FILM_ID"));
            User user = usersDAO.findById(rs.getString("USERNAME"));

            Preference fetchedPreference = Preference.builder()
                    .film(film)
                    .user(user)
                    .build();
            return fetchedPreference;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Preference preference) throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM amt_preferences WHERE FILM=ID=? AND USERNAME=?");
            long filmid = preference.getFilm().getId();
            String username = preference.getUser().getUsername();
            statement.setString(1, String.valueOf(filmid));
            statement.setString(2, username);
            int deletedPreferences = statement.executeUpdate();
            if(deletedPreferences != 1) {
                throw new KeyNotFoundException("Could not find preference with film_id " + filmid + " and username " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Film> findAllByUsername(String username) throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM amt_preferences WHERE USERNAME=?");
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if(!hasRecord) {
                throw new KeyNotFoundException("Could not find any preferences for given username: " + username);
            }
            List<Film> films = new LinkedList<>();
            FilmsDAO filmsDAO = new FilmsDAO();

            while (rs.next()) {
                Film film = filmsDAO.findById(rs.getString("FILM_ID"));
                films.add(film);
            }
            return films;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
