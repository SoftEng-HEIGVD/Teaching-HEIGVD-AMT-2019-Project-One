package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductsManagerLocal {

    //E create(E entity) throws DuplicateKeyException;
    List<Product> getAllProducts();
    Product findById(int id) throws KeyNotFoundException;
    void update(Product entity) throws KeyNotFoundException;
    void deleteById(int id) throws KeyNotFoundException;

}
