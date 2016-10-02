package ua.joit.java.spring.mvc.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.WarehouseDao;
import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.model.Ingredient;
import ua.joit.java.spring.mvc.model.Warehouse;

import java.util.List;

public class HWarehouseDao implements WarehouseDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public void create(Warehouse warehouse) {
        if (!findAll().contains(warehouse))
        sessionFactory.getCurrentSession().merge(warehouse);
    }

    @Override
    @Transactional
    public void remove(Warehouse warehouse) {
        sessionFactory.getCurrentSession().remove(warehouse);
    }

    @Override
    @Transactional
    public void changeQuantityOfIngredients(String ingredientName, Float quantity) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update Warehouse set quantity = :quantity where ingredient.name = :ingredientName");
        query.setParameter("quantity", quantity);
        query.setParameter("ingredientName", ingredientName);
        query.executeUpdate();
    }
    @Override
    @Transactional
    public void changeQuantity(Warehouse warehouse, Float newQuantity) {
        warehouse.setQuantity(newQuantity);

        sessionFactory.getCurrentSession().update(warehouse);

    }

    @Override
    @Transactional
    public Warehouse findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select w from Warehouse w where w.ingredient.name = :name");
        query.setParameter("name", name);
        return (Warehouse) query.uniqueResult();
    }
    @Override
    @Transactional
    public Warehouse getById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select w from Warehouse w where w.id = :id");
        query.setParameter("id", id);
        Warehouse result = (Warehouse) query.uniqueResult();
        if (result == null) {
            throw new RuntimeException("Ingredient was not fount by id = " + id);
        }
        return result;
    }
    public Warehouse getWarehouseIngredientById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Warehouse i where i.ingredient.id = :id");
        query.setParameter("id", id);
        return (Warehouse) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Warehouse> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w").list();
    }

    @Override
    @Transactional
    public List<Warehouse> findEndsIngredients() {
        return sessionFactory.getCurrentSession().createQuery("select w from Warehouse w where w.quantity < 10").list();
    }

    @Override
    @Transactional
    public void removeAllWarehouse() {
        sessionFactory.getCurrentSession().createQuery("delete from Warehouse").executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
