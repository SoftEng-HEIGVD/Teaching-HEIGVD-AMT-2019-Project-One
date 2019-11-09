package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.Preference;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// TODO:  save Error messages
public class PreferencesDAO implements IPreferencesDAO {

    // For Payara (see http://mjremijan.blogspot.com/2015/11/payaraglassfish-datasource-reference.html)
    @Resource(lookup = "jdbc/film_library")
    DataSource dataSource;

    // For Wildfly (see https://docs.jboss.org/author/display/WFLY10/JNDI+Reference)
    //@Resource(lookup = "java:/jdbc/film_library")
    //DataSource dataSource;

    public Preference create(Preference entity) throws DuplicateKeyException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO amt_preferences (FILM_ID, USERNAME) VALUES (?,?)");
            statement.setString(1, String.valueOf(entity.getFilm().getId()));
            statement.setString(2, entity.getUser().getUsername());
            statement.execute();
            return entity;
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
