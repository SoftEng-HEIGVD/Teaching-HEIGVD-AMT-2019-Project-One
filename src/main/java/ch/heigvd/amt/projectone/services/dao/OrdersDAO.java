package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Order;

public class OrdersDAO implements IOrdersDAO{
    @Override
    public Order create(Order entity) throws DuplicateKeyException {
        return null;
    }

    @Override
    public Order findById(Integer id) throws KeyNotFoundException {
        return null;
    }

    @Override
    public void update(Order entity) throws KeyNotFoundException {

    }

    @Override
    public void deleteById(Integer id) throws KeyNotFoundException {

    }
}
