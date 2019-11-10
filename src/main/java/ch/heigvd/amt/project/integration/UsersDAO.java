package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.model.User;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class UsersDAO implements IUsersDAO {

    // For Payara (see http://mjremijan.blogspot.com/2015/11/payaraglassfish-datasource-reference.html)
    @Resource(lookup = "jdbc/film_library")
    DataSource dataSource;

    // For Wildfly (see https://docs.jboss.org/author/display/WFLY10/JNDI+Reference)
    //@Resource(lookup = "java:/jdbc/film_library")
    //DataSource dataSource;

    /*@EJB
    IAuthenticationService authenticationService;*/

    @Override
    public User create(User entity) throws DuplicateKeyException {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO amt_users (USERNAME, FIRST_NAME, LAST_NAME, EMAIL, HASHED_PW) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, entity.getUsername());
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getLastName());
            statement.setString(4, entity.getEmail());
            statement.setString(5, entity.getPassword());
            statement.execute();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }
    }

    @Override
    public User findById(String username) throws KeyNotFoundException {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT USERNAME, FIRST_NAME, LAST_NAME, EMAIL FROM amt_users WHERE USERNAME = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            boolean hasRecord = rs.next();
            if (!hasRecord) {
                throw new KeyNotFoundException("Could not find user with username = " + username);
            }
            User existingUser = User.builder()
                    .username(rs.getString(1))
                    .firstName(rs.getString(2))
                    .lastName(rs.getString(3))
                    .email(rs.getString(4))
                    .build();
            return existingUser;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }
    }

    // TODO: delete in preferences too
    @Override
    public void deleteById(String username) throws KeyNotFoundException {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("DELETE FROM amt_users WHERE USERNAME = ?");
            statement.setString(1, username);
            int numberOfDeletedUsers = statement.executeUpdate();
            if (numberOfDeletedUsers != 1) {
                throw new KeyNotFoundException("Could not find user with username = " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
        }
    }

    @Override
    public List<User> findAll() throws KeyNotFoundException {
        return null;
    }

    @Override
    public void update(User entity) throws KeyNotFoundException {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE amt_users SET FIRST_NAME=?, LAST_NAME=?, EMAIL=? WHERE USERNAME = ?");
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getUsername());
            int numberOfUpdatedUsers = statement.executeUpdate();
            if (numberOfUpdatedUsers != 1) {
                throw new KeyNotFoundException("Could not find user with username = " + entity.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        } finally {
            closeConnection(con);
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
