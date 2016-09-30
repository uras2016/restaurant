package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.MenuDao;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Menu;

import java.util.List;

public class MenuService {
    private MenuDao menuDao;

    @Transactional
    public List<Menu> getMenus() {
        return menuDao.findAll();
    }

    @Transactional
    public List<Menu> findAllNames() {
        return menuDao.findAllNames();
    }

    @Transactional
    public Menu getMenuByName(String name) {
        return menuDao.getByName(name);
    }

    @Transactional
    public void add(Menu menu) {
        menuDao.add(menu);
    }

    @Transactional
    public void remove(Menu menu) {
        menuDao.remove(menu);
    }

    @Transactional
    public Menu getByName(String name) {
        return menuDao.getByName(name);
    }

    @Transactional
    public Menu getById(Long id) {
        return menuDao.getById(id);
    }

    @Transactional
    public void addDishToMenu(Dish dish, Menu menu) {
        menuDao.addDish(dish, menu);
    }

    @Transactional
    public void deleteDishFromMenu(Dish dish, Menu menu) {
        menuDao.deleteDish(dish, menu);
    }


    @Autowired
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
