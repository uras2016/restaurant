package ua.joit.java.spring.mvc.dao;

import ua.joit.java.spring.mvc.model.Warehouse;

import java.util.List;

public interface WarehouseDao {

    void create(Warehouse warehouse);
    void remove(Warehouse warehouse);
    void changeQuantityOfIngredients(String ingredientName, Float quantity);

    void changeQuantity(Warehouse warehouse, Float newQuantity);

    Warehouse findByName(String name);

    public Warehouse getById(Long id);

    List<Warehouse> findAll();
    List<Warehouse> findEndsIngredients();

    void removeAllWarehouse();
}
