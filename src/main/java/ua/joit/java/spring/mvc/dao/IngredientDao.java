package ua.joit.java.spring.mvc.dao;

import ua.joit.java.spring.mvc.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    void addIngredient(Ingredient ingredient);
    void removeIngredient(Ingredient ingredient);

    List<Ingredient> findAllIngredients();
    Ingredient findByName(String name);

    Ingredient findById(Long id);

    void removeAllIngredients();
}
