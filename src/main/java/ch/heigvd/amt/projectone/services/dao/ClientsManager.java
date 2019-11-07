package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.model.Client;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Stateless
public class ClientsManager implements ClientsManagerLocal {

    @Resource(lookup = "jdbc/chillout")
    private DataSource dataSource;

    @Override
    public boolean create(String username, String password) {
        return false;
    }

    @Override
    public boolean validConnection(String username, String password) {
        boolean valid = false;
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()){
                String passwordDB = result.getString("password");
                if (password.equals(passwordDB)){
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
        Client client = Client.builder().build();

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String userDB = result.getString("username");
                String passDB = result.getString("password");

                client.setId(id);
                client.setName(name);
                client.setUsername(userDB);
                client.setPassword(passDB);
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }
}
