package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Order;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//

@Stateless
public class OrdersManager implements OrdersManagerLocal {

    @Resource(lookup = "jdbc/chillout")
    DataSource dataSource;

    public List<Order> getAllOrders(){

        List<Order> orders = new ArrayList<>();

        try{
            Connection connection = dataSource.getConnection();

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `Order`");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int idClient = rs.getInt("idClient");
                String command = rs.getString("command");
                orders.add(new Order(id, idClient, command));
            }

            connection.close();

        }
        catch (SQLException ex){
            Logger.getLogger(OrdersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;

    }

    public List<Order> findOrdersByClientId(int idClient) {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Order` WHERE idClient = ?");
            preparedStatement.setInt(1, idClient);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                int id = result.getInt("id");
                int idClientDB = result.getInt("idClient");
                String command = result.getString("command");

                orders.add(new Order(id,idClientDB,command));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return orders;

    }

    @Override
    public Order create(Order entity) throws DuplicateKeyException {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `Order` (idClient, command) VALUES(?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.getIdClient());
            statement.setString(2, entity.getCommand());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return entity;

    }

    @Override
    public Order findById(int id) throws KeyNotFoundException {
        Order order = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Order` WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                int idDB = result.getInt("id");
                int idClient = result.getInt("idClient");
                String command = result.getString("command");

                order = new Order(idDB,idClient,command);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return order;

    }


    @Override
    public void update(Order entity) throws KeyNotFoundException {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Order SET command = ? WHERE id = ?");
            preparedStatement.setString(1, entity.getCommand());
            preparedStatement.setInt(2, entity.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement(" DELETE ORDER WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }

}
