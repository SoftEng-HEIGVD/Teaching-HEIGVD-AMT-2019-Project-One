package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.Order;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrdersManagerLocal extends IDAO<Order>{

    List<Order> getAllOrders();
    List<Order> findOrdersByClientId(int idClient);
}
