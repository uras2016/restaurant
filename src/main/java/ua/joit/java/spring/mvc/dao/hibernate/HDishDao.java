package ua.joit.java.spring.mvc.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.Exceptions.ProhibitionException;
import ua.joit.java.spring.mvc.dao.DishDao;
import ua.joit.java.spring.mvc.dao.WarehouseDao;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Ingredient;
import ua.joit.java.spring.mvc.model.Menu;
import ua.joit.java.spring.mvc.model.Warehouse;

import java.util.List;

public class HDishDao implements DishDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private WarehouseDao warehouseDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().saveOrUpdate(dish);
    }

//    @Transactional(propagation = Propagation.MANDATORY)
//    public void checkIngredientsInWarehouse(Dish dish) {
//
//        List<Ingredient> ingredientsInDish = dish.getIngredients();
//        for (Ingredient ingredient : ingredientsInDish) {
//
//            Warehouse warehouse = warehouseDao.getById(ingredient.getId());
//            Float warehouseIngredientQuantity = warehouse.getQuantity();
//
//            Float newQuantity = warehouseIngredientQuantity - 1F;
//
//
//            if (newQuantity > 0) {
//                warehouseDao.changeQuantity(warehouse, newQuantity);
//
//            } else {
//                throw new ProhibitionException("Ingredient " + ingredient.getName() + "is over. Ingredient quantity = " + warehouseIngredientQuantity);
//
//            }
//
//        }
//    }

    @Override
    @Transactional
    public List<Dish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select d from Dish d").list();
    }

    @Override
    @Transactional
    public Dish findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Dish e where e.name like :name"); // :name - параметр, переданный в запрос
        query.setParameter("name", name);
        Dish dish = (Dish) query.uniqueResult();
//        if (dish == null) {
//            throw new RuntimeException("Dish " + name + " was not fount ");
//        }
        return dish;
    }

    @Override
    @Transactional
    public void removeAllDishes() {

        sessionFactory.getCurrentSession().createQuery("delete from Dish").executeUpdate();
    }

    @Override
    public Dish getById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select d from Dish d where d.id = :id");
        query.setParameter("id", id);
        Dish result = (Dish) query.uniqueResult();
        if (result == null) {
            throw new RuntimeException("Dish was not fount by id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public void remove(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
