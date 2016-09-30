package ua.joit.java.spring.mvc.dao;

import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Menu;

import java.util.List;

public interface MenuDao {

    void add(Menu menu);
    void remove(Menu menu);
    void addDish(Dish dish, Menu menu/*List<Dish>*/);

    Menu getById(Long id);

    void deleteDish(Dish dish, Menu menu/*TODO:List<Dish>*/);
    Menu getByName(String name);
    List<Menu> findAll();

    List<Menu> findAllNames();

    void removeAllMenus();
}
