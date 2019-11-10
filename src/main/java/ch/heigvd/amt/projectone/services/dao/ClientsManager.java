package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Client;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;

@Stateless
public class ClientsManager implements ClientsManagerLocal {
    @Resource(lookup = "jdbc/chillout")
    private DataSource dataSource;


    @Override
    public Client create(Client entity) throws DuplicateKeyException {

        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `Client` (name, username, password, isAdmin) VALUES(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getUsername());
            statement.setString(3, entity.getPassword());
            statement.setBoolean(4, entity.isAdmin());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return entity;

    }

    @Override
    public Client findById(int id) throws KeyNotFoundException {
        Client client = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return client;

    }

    @Override
    public void update(Client entity) throws KeyNotFoundException {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `Client` SET name=?, username=?, password=?, isAdmin=? WHERE id=?;");
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getUsername());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setBoolean(4, entity.isAdmin());
            preparedStatement.setInt(5, entity.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void deleteById(int id) throws KeyNotFoundException {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" DELETE Client WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }


    public Client findClientByUsername(String username) {
        Client client = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return client;

    }

    public int getIdByUsername(String username) {

        int id = -1;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM `Client` WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                id = result.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return id;

    }

    public Client getClientById(int id){

        Client client = null;
        Connection connection = null;


        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Client` WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()){
                int idDB = result.getInt("id");
                String name = result.getString("name");
                String userDB = result.getString("username");
                String passDB = result.getString("password");
                boolean isAdmin = result.getBoolean("isAdmin");

                client = new Client(id, name, userDB, passDB, isAdmin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return client;

    }
}
