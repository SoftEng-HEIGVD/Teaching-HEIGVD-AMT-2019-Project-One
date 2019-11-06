package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;


public interface IDAO<PK, E> {
    E create(E entity) throws DuplicateKeyException;
    E findById(PK id) throws KeyNotFoundException;
    void update(E entity) throws KeyNotFoundException;
    void deleteById(PK id) throws KeyNotFoundException;
}