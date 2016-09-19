package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.IngredientDao;
import ua.joit.java.spring.mvc.model.Ingredient;

import java.util.List;

public class IngredientService {
    private IngredientDao ingredientDao;

    @Transactional
    public List<Ingredient> getIngredients() {
        return ingredientDao.findAllIngredients();
    }

    @Transactional
    public Ingredient getIngredientByName(String name) {
        return ingredientDao.findByName(name);
    }

    @Autowired
    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

}




