package ua.joit.java.spring.mvc.dao;

import ua.joit.java.spring.mvc.model.PreparedDish;

import java.util.List;

public interface PreparedDishesDAO {

    void create(PreparedDish preparedDish);
    List<PreparedDish> findAll();

    void removeAllPreparedDishes();
}
