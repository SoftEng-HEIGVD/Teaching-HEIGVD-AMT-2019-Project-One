package ch.heigvd.amt.projectone.services.dao;

import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Order;
import ch.heigvd.amt.projectone.model.Product;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import javax.faces.component.search.SearchKeywordResolver;
import java.util.List;


public interface IOrdersDAO extends IDAO{

    List<Order> getAllOrders();
    Order findById(int id) throws KeyNotFoundException;
    void update(Order order) throws KeyNotFoundException;
    void deleteById(int id) throws KeyNotFoundException;
}
