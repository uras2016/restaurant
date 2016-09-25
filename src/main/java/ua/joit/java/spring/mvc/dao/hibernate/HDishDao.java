package ua.joit.java.spring.mvc.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.DishDao;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Menu;

import java.util.List;

public class HDishDao implements DishDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().saveOrUpdate(dish);
    }

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
        return (Dish) query.uniqueResult();
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
