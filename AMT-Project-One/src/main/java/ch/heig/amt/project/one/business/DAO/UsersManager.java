package ch.heig.amt.project.one.business.DAO;

import ch.heig.amt.project.one.business.interfaces.UsersManagerLocal;
import ch.heig.amt.project.one.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UsersManager implements UsersManagerLocal {
    @Resource(lookup = "jdbc/amtDatasource")
    private DataSource dataSource;

    public boolean create(User u) {
        return false;
    }

    public boolean connection(String username, String password) {
        boolean connectionValid = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE Username = ?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            String passwordDB = rs.getString("Password");

            if(passwordDB.equals(password)) {
                connectionValid = true;
            }
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.UsersManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return connectionValid;
    }

    public User getUserByUsername(String username) {
        User user = null;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE Username = ?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                String passwordDB = rs.getString("Password");
                String usernameDB = rs.getString("Username");
                long id = rs.getLong("ID");

                user.setUsername(usernameDB);
                user.setPassword(passwordDB);
                user.setId(id);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.getLogger(ch.heig.amt.project.one.business.DAO.UsersManager.class.getName()).log(Level.SEVERE, null, e);
        }
        return user;
    }
}
