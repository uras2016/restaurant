package ua.joit.java.spring.mvc.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.IngredientDao;
import ua.joit.java.spring.mvc.model.Ingredient;

import java.util.List;

public class HIngredientDao implements IngredientDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addIngredient(Ingredient ingredient) {
       sessionFactory.getCurrentSession().saveOrUpdate(ingredient);
    }

    @Override
    @Transactional
    public void removeIngredient(Ingredient ingredient) {
        sessionFactory.getCurrentSession().remove(ingredient);
    }

    @Override
    @Transactional
    public List<Ingredient> findAllIngredients() {
        return sessionFactory.getCurrentSession().createQuery("select i from Ingredient i").list();
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select i from Ingredient i where i.name = :name");
        query.setParameter("name", name);
        return (Ingredient) query.uniqueResult();
    }

    @Override
    @Transactional
    public Ingredient findById(Long id) {
        Ingredient result = sessionFactory.getCurrentSession().get(Ingredient.class, id);
        if (result == null) {
            throw new RuntimeException("Wrong id = " + id);
        }
        return result;
    }
    @Override
    public void removeAllIngredients() {
        sessionFactory.getCurrentSession().createQuery("delete from Ingredient").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
