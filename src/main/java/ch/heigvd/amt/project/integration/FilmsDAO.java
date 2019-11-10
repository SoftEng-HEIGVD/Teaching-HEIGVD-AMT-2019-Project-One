package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Film;

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
public class FilmsDAO implements IFilmsDao {

    // For Payara (see http://mjremijan.blogspot.com/2015/11/payaraglassfish-datasource-reference.html)
    @Resource(lookup = "jdbc/film_library")
    DataSource dataSource;

    // For Wildfly (see https://docs.jboss.org/author/display/WFLY10/JNDI+Reference)
    //@Resource(lookup = "java:/jdbc/film_library")
    //DataSource dataSource;

    @Override
    public Film create(Film entity) throws DuplicateKeyException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO amt_films (ID, TITLE, RUNNING_TIME, PATH_TO_POSTER, DIRECTOR) VALUES (?,?,?,?,?)");
            statement.setString(1, String.valueOf(entity.getId()));
            statement.setString(2, entity.getTitle());
            statement.setString(3, String.valueOf(entity.getRunningTime()));
            statement.setString(4, entity.getMoviePosterPath());
            statement.setString(5, entity.getDirector());
            statement.execute();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Film findById(String id) throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT ID, TITLE, RUNNING_TIME, PATH_TO_POSTER, DIRECTOR FROM amt_films WHERE ID = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if (!hasRecord) {
                throw new KeyNotFoundException("Could not find film with film_id = " + id);
            }
            Film existingFilm = Film.builder()
                    .id(Long.parseLong(rs.getString(1)))
                    .title(rs.getString(2))
                    .runningTime(Integer.parseInt(rs.getString(3)))
                    .moviePosterPath(rs.getString(4))
                    .director(rs.getString(5))
                    .build();
            return existingFilm;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Film entity) throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE amt_films SET TITLE=?, RUNNING_TIME=?, PATH_TO_POSTER=?, DIRECTOR=? WHERE ID = ?");
            statement.setString(1, entity.getTitle());
            statement.setString(2, String.valueOf(entity.getRunningTime()));
            statement.setString(3, entity.getMoviePosterPath());
            statement.setString(4, entity.getDirector());
            statement.setString(5, String.valueOf(entity.getId()));
            int updatedFilms = statement.executeUpdate();
            if(updatedFilms != 1) {
                throw new KeyNotFoundException("Could not find film with film_id = " + entity.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    // TODO: delete in preferences too
    @Override
    public void deleteById(String id) throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM amt_films WHERE ID=?");
            statement.setString(1, id);
            int deletedFilms = statement.executeUpdate();
            if (deletedFilms != 1) {
                throw new KeyNotFoundException("Could not find film with film_id = " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Film> findAll() throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM amt_films");
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if (!hasRecord) {
                throw new KeyNotFoundException("Could not find any film!");
            }
            List<Film> existingFilms = new LinkedList<>();

            while (rs.next()) {
                Film existingFilm = Film.builder()
                        .id(Long.parseLong(rs.getString("ID")))
                        .title(rs.getString("TITLE"))
                        .runningTime(Integer.parseInt(rs.getString("RUNNING_TIME")))
                        .moviePosterPath(rs.getString("PATH_TO_POSTER"))
                        .director(rs.getString("DIRECTOR"))
                        .build();
                existingFilms.add(existingFilm);
            }
            return  existingFilms;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Film> findBetween(String id1, String id2) throws KeyNotFoundException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM amt_films WHERE ID >= ? AND ID < ?");
            statement.setString(1, id1);
            statement.setString(2, id2);
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if (!hasRecord) {
                throw new KeyNotFoundException("Could not find any film!");
            }
            List<Film> requestedFilms = new LinkedList<>();

            while (rs.next()) {
                Film existingFilm = Film.builder()
                        .id(Long.parseLong(rs.getString("ID")))
                        .title(rs.getString("TITLE"))
                        .runningTime(Integer.parseInt(rs.getString("RUNNING_TIME")))
                        .moviePosterPath(rs.getString("PATH_TO_MOVIE_POSTER"))
                        .director(rs.getString("DIRECTOR"))
                        .build();
                requestedFilms.add(existingFilm);
            }
            return requestedFilms;
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
