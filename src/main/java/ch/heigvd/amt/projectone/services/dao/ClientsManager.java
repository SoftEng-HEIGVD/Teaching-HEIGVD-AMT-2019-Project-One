package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.model.Client;

import javax.annotation.Resource;
import javax.ejb.PrePassivate;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;

@Stateless
public class ClientsManager implements ClientsManagerLocal {
    @Resource(lookup = "jdbc/chillout")
    private DataSource dataSource;


    @Override
    public boolean create(String name, String username, String password, String password_confirm) {
        boolean created = false;

        if (password.equals(password_confirm)) {
            int id = -1;
            try {
                Connection connection = dataSource.getConnection();

                PreparedStatement statement = connection.prepareStatement("INSERT INTO `Client` (name, username, password, isAdmin) VALUES(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, name);
                statement.setString(2, username);
                statement.setString(3, password);
                statement.setBoolean(4, false);
                statement.executeUpdate();

                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()){
                    id = rs.getInt(1);
                }

                if (id != -1){
                    created = true;
                }

                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }

        return created;
    }

    @Override
    public boolean validConnection(String username, String password) {
        boolean valid = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE username=?");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                String passwordDB = result.getString("password");
                if (password.equals(passwordDB)) {
                    valid = true;
                }
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public Client findClientByUsername(String username) {
        Client client = null;

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Client` WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String userDB = result.getString("username");
                String passDB = result.getString("password");
                boolean isAdmin = result.getBoolean("isAdmin");

                client = new Client(id, name, userDB, passDB, isAdmin);
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public int getIdByUsername(String username) {

        int id = -1;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM `Client` WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                id = result.getInt("id");
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public Client getClientById(int id) {

        Client client = null;

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Client` WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                int idDB = result.getInt("id");
                String name = result.getString("name");
                String userDB = result.getString("username");
                String passDB = result.getString("password");
                boolean isAdmin = result.getBoolean("isAdmin");

                client = new Client(id, name, userDB, passDB, isAdmin);
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }
}
