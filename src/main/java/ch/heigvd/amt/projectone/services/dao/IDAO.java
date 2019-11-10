package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;

import java.sql.Connection;
import java.sql.SQLException;


public interface IDAO<E> {
    E create(E entity) throws DuplicateKeyException;
    E findById(int id) throws KeyNotFoundException;
    void update(E entity) throws KeyNotFoundException;
    void deleteById(int id) throws KeyNotFoundException;

    default void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}