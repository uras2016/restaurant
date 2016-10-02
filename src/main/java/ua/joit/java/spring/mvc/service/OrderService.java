package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.OrderDao;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Orders;
import ua.joit.java.spring.mvc.model.Status;

import java.util.List;

public class OrderService {
    private OrderDao orderDao;


    @Transactional
    public List<Orders> findAllOrders() {
        return orderDao.findAllOrders();
    }

    @Transactional
    public Orders getById(Long id) {
        return orderDao.findById(id);
    }

    @Transactional
    public List<Orders> findAllOpenedOrders() {
        return orderDao.findSpecialOrders(Status.OPEN);
    }

    @Transactional
    public List<Orders> findAllClosedOrders() {
        return orderDao.findSpecialOrders(Status.CLOSE);

    }

    @Transactional
    public void add(Orders order) {
        orderDao.save(order);
    }

    @Transactional
    public void closeOrder(Orders order) {
        orderDao.closeOrder(order);
    }

    @Transactional
    public void addDishToOrder(Dish dish, Orders orders) {
        orderDao.addDishToOrder(dish, orders);
    }


    @Transactional
    public void removeOrder(Orders order) {
        orderDao.deleteOrder(order);
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
