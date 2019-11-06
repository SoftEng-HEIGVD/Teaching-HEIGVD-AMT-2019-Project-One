package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Client;

public class ClientsDAO implements IClientsDAO{
    @Override
    public Client create(Client entity) throws DuplicateKeyException {
        return null;
    }

    @Override
    public Client findById(Integer id) throws KeyNotFoundException {
        return null;
    }

    @Override
    public void update(Client entity) throws KeyNotFoundException {

    }

    @Override
    public void deleteById(Integer id) throws KeyNotFoundException {

    }
}
