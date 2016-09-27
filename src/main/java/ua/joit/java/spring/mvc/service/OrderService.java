package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.OrderDao;
import ua.joit.java.spring.mvc.model.Orders;

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

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
