package ua.joit.java.spring.mvc.dao;

import ua.joit.java.spring.mvc.model.Dish;

import java.util.List;

public interface DishDao {

    void save(Dish dish);
    void remove(Dish dish);

    List<Dish> findAll();
    Dish findByName(String name);

    void removeAllDishes();

    Dish getById(Long id);
}
