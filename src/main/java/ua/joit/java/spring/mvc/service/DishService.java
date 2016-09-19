package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.DishDao;
import ua.joit.java.spring.mvc.model.Dish;

import java.util.List;

public class DishService {
    private DishDao dishDao;

    @Transactional
    public List<Dish> getDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getMenuByName(String name) {
        return dishDao.findByName(name);
    }

    @Autowired
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}



