package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;

import java.util.List;

public interface IDAO<PK, E> {
    E create(E entity) throws DuplicateKeyException;
    E findById(PK id) throws KeyNotFoundException;
    void update(E entity) throws KeyNotFoundException;
    void deleteById(PK id) throws KeyNotFoundException;
    List<E> findAll() throws KeyNotFoundException;
}

