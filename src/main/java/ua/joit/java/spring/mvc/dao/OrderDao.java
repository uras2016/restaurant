package ua.joit.java.spring.mvc.dao;

import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Orders;
import ua.joit.java.spring.mvc.model.Status;

import java.util.List;

public interface OrderDao {

    void save(Orders order);
    void deleteOrder(Orders orders);
    Orders findById(Long id);
    void addDishToOrder(Dish dish, Orders orders);
    void deleteDishFromOrder(Dish dish, Orders orders);
    void closeOrder(Orders orders);
    List<Orders> findAllOrders();
    List<Orders> findAllOpenedOrders();

    List<Orders> findSpecialOrders(Status status);

    List<Orders> findAllClosedOrders();

    void removeAllOrders();
}
