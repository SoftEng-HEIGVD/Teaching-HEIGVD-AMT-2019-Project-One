package ch.heigvd.amt.projectone.DAO;

import javax.ejb.DuplicateKeyException;

public interface IDAO <PK, E> {
    E create(E entity) throws DuplicateKeyException;
    E findById(PK id);
    void update(E entity);
    void deleteById(PK id);
}
