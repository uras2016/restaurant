package ua.joit.java.spring.mvc.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.Exceptions.ProhibitionException;
import ua.joit.java.spring.mvc.dao.OrderDao;
import ua.joit.java.spring.mvc.dao.WarehouseDao;
import ua.joit.java.spring.mvc.model.*;

import java.util.ArrayList;
import java.util.List;

public class HOrderDao implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private WarehouseDao warehouseDao;


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Orders order) {
        order.setOpenStatus(Status.OPEN);
        List<Dish> dishes = order.getDishes();
        for (Dish dish : dishes) {
            checkIngredientsInWarehouse(dish); // validation
        }
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteOrder(Orders order) {
        if (order.getStatus() == Status.OPEN) {

            sessionFactory.getCurrentSession().remove(order);
        } else {
            throw new IllegalArgumentException("Order is not open");
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Orders findById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select o from Orders o where o.id = :id");
        query.setParameter("id", id);
        return (Orders) query.uniqueResult();
    }

    @Transactional
    public Orders getById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select o from Orders o where o.id = :id");
        query.setParameter("id", id);
        Orders result = (Orders) query.uniqueResult();
        if (result == null) {
            throw new RuntimeException("Order was not fount by id = " + id);
        }
        return result;
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void addDishToOrder(Dish dish, Orders orders) {
        if (orders.getStatus() == Status.CLOSE) {
            throw new ProhibitionException("Order was closed");
        } else {
            if (!orders.getDishes().contains(dish)) {
                orders.getDishes().add(dish);
                sessionFactory.getCurrentSession().saveOrUpdate(orders);
            }
        }
    }


    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteDishFromOrder(Dish dish, Orders orders) {
        if (orders.getDishes().contains(dish)) {
            orders.getDishes().remove(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(orders);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void closeOrder(Orders order) {
        if (order.getStatus() == Status.OPEN) {
            order.setOpenStatus(Status.CLOSE);

            List<PreparedDish> allPreparedDishes = new ArrayList<>();

            for (Dish dish : order.getDishes()) {
                PreparedDish preparedDish = new PreparedDish();
                preparedDish.setDish(dish);
                preparedDish.setDate(order.getOrderDate());
                preparedDish.setCooker(order.getWaiter());

                allPreparedDishes.add(preparedDish);
            }

            order.setPreparedDishes(allPreparedDishes);
            sessionFactory.getCurrentSession().saveOrUpdate(order);
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void checkIngredientsInWarehouse(Dish dish) {

        List<Ingredient> ingredientsInDish = dish.getIngredients();
        for (Ingredient ingredient : ingredientsInDish) {

            Warehouse warehouse = warehouseDao.getById(ingredient.getId());
            Float warehouseIngredientQuantity = warehouse.getQuantity()-1F;

//            Float newQuantity = warehouseIngredientQuantity - 1F;


            if (warehouseIngredientQuantity > 0) {
                warehouseDao.changeQuantity(warehouse, warehouseIngredientQuantity);

            } else {
                throw new ProhibitionException("Ingredient " + ingredient.getName() + "is over. Ingredient quantity = " + warehouseIngredientQuantity);

            }

        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Orders> findAllOpenedOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o where o.status = :status").list();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Orders> findSpecialOrders(Status status) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from Orders o where o.status like :status"); // :name - параметр, переданный в запрос
        query.setParameter("status", status); // "name" должен совпадать с параметром в квери - :name
        return query.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Orders> findAllClosedOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o where o.status = :1").list();

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Orders> findAllOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Orders o").list();
    }

    @Override
    @Transactional
    public void removeAllOrders() {
        sessionFactory.getCurrentSession().createQuery("delete from Orders").executeUpdate();
    }

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
