package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Order;
import ch.heigvd.amt.projectone.model.Product;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersDAO implements IOrdersDAO{

    @Resource(lookup = "jdbc/chillout")
    DataSource dataSource;

    public List<Order> getAllOrders(){

        List<Order> products = new ArrayList<>();

        try{
            Connection connection = dataSource.getConnection();
            System.out.println("Schema : "+connection.getSchema());
            System.out.println("Catalog : "+connection.getCatalog());

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Product");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int idClient = rs.getInt("idClient");
                String description = rs.getString("description");
                products.add(new Order(id, idClient, description));
            }

            connection.close();

        }
        catch (SQLException ex){
            Logger.getLogger(ProductsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;

    }
}
