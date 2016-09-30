package ua.joit.java.spring.mvc.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.MenuDao;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Menu;

import java.util.List;

public class HMenuDao implements MenuDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(Menu menu) {
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
    }

    @Override
    @Transactional
    public void remove(Menu menu) {
        sessionFactory.getCurrentSession().remove(menu);
    }

    @Override
    @Transactional
    public void addDish(Dish dish, Menu menu) {
        if (!menu.getDishes().contains(dish)){
            menu.getDishes().add(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(menu);
        }else {
            throw new RuntimeException("This dish is already included");
        }
    }
    @Override
    @Transactional
    public Menu getById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.id = :id");
        query.setParameter("id", id);
        Menu result = (Menu) query.uniqueResult();
        if (result == null) {
            throw new RuntimeException("Menu was not fount by id = " + id);
        }
        return result;
    }




//    @Transactional
//    public Menu getById(Long id) {
//        Menu result = sessionFactory.getCurrentSession().get(Menu.class, id);
//        if(result==null) {
//            throw new RuntimeException("Wrong id = " + id);
//        }
//        return result;
//    }

    @Override
    @Transactional
    public void deleteDish(Dish dish, Menu menu) {
        menu.getDishes().remove(dish);
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
    }

    @Override
    @Transactional
    public Menu getByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.name = :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Menu> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();

    }
    @Override
    @Transactional
    public List<Menu> findAllNames() {
        return sessionFactory.getCurrentSession().createQuery("select m.name from Menu m").list();

    }


    @Override
    @Transactional
    public void removeAllMenus() {
        sessionFactory.getCurrentSession().createQuery("delete from Menu").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
