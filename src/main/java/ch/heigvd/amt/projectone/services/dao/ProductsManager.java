package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Client;
import ch.heigvd.amt.projectone.model.Product;
import ch.heigvd.amt.projectone.web.ProfileServlet;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ProductsManager implements ProductsManagerLocal {

    @Resource(lookup = "jdbc/chillout")
    private DataSource dataSource;

    public List<Product> getAllProducts() {

        Connection connection = null;
        List<Product> products = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            System.out.println("Schema : " + connection.getSchema());
            System.out.println("Catalog : " + connection.getCatalog());

            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `Product`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double unitPrice = rs.getDouble("unitPrice");
                String description = rs.getString("description");
                products.add(new Product(id, name, unitPrice, description));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public Product create(Product entity) throws DuplicateKeyException {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO `Product` (name, unitPrice, description) VALUES(?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getName());
            statement.setDouble(2, entity.getUnitPrice());
            statement.setString(3, entity.getDescription());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return entity;
    }

    @Override
    public Product findById(int id) throws KeyNotFoundException {
        Product product = null;
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Product` WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                int idDB = result.getInt("id");
                String name = result.getString("name");
                Double unitPrice = result.getDouble("unitPrice");
                String description = result.getString("description");

                product = new Product(idDB, name, unitPrice, description);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return product;
    }

    @Override
    public void update(Product entity) throws KeyNotFoundException {


        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Product SET name = ?, unitPrice = ?, description = ? WHERE id = ?");
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getUnitPrice());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement(" DELETE Product WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }


}
