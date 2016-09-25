package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.DishDao;
import ua.joit.java.spring.mvc.model.Dish;

import java.util.List;

public class DishService {
    private DishDao dishDao;

    @Transactional
    public void save(Dish dish) {
        dishDao.save(dish);
    }
    @Transactional
    public void removeDish(Dish dish) {
        dishDao.remove(dish);
    }

    @Transactional
    public List<Dish> getDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    @Transactional
    public Dish findByName(String name) {
        return dishDao.findByName(name);
    }

    @Transactional
    public Dish getById(Long id) {
        return dishDao.getById(id);
    }




    @Autowired
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}



