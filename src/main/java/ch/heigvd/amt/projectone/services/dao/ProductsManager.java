package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Product;

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
public class ProductsManager implements ProductsManagerLocal {

    @Resource(lookup = "jdbc/chillout")
    private DataSource dataSource;

    public List<Product> getAllProducts(){

        List<Product> products = new ArrayList<>();

        try{
            Connection connection = dataSource.getConnection();
            System.out.println("Schema : "+connection.getSchema());
            System.out.println("Catalog : "+connection.getCatalog());

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Product");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double unitPrice = rs.getDouble("unitPrice");
                String description = rs.getString("description");
                products.add(new Product(id,name,unitPrice,description));
            }

            connection.close();

        }
        catch (SQLException ex){
            Logger.getLogger(ProductsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;

    }

    @Override
    public Product findById(int id) throws KeyNotFoundException {
        return null;
    }

    @Override
    public void update(Product entity) throws KeyNotFoundException {

    }

    @Override
    public void deleteById(int id) throws KeyNotFoundException {

    }
}
