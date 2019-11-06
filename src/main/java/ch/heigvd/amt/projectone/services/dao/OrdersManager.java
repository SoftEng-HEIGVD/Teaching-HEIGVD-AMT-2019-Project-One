package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Order;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class OrdersManager implements OrdersManagerLocal {

    @Resource(lookup = "jdbc/chillout")
    DataSource dataSource;

    public List<Order> getAllOrders(){

        List<Order> orders = new ArrayList<>();

        try{
            Connection connection = dataSource.getConnection();
            System.out.println("Schema : "+connection.getSchema());
            System.out.println("Catalog : "+connection.getCatalog());

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

    @Override
    public Order create(Order entity) throws DuplicateKeyException {
        return null;
    }

    @Override
    public Order findById(Integer id) throws KeyNotFoundException {
        return null;
    }

    @Override
    public void update(Order entity) throws KeyNotFoundException {

    }

    @Override
    public void deleteById(Integer id) throws KeyNotFoundException {

    }
}
