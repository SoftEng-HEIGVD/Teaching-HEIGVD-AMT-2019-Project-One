package ch.heigvd.amt.project.integration;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;

import java.util.List;

/**
 * IDAO interface for relationships between two entities
 * @param <U> First entity
 * @param <F> Second entity
 * @param <P> Relationship
 */
// TODO: Do it in a concrete class

public interface IDAORelation<U, F, P> {
    P create(P entity) throws DuplicateKeyException;
    P findByIds(U id1, F id2) throws KeyNotFoundException;
    void update(P entity) throws KeyNotFoundException;
    void deleteByIds(U id1, F id2) throws KeyNotFoundException;
    List<P> findAll() throws KeyNotFoundException;
}
