package ua.joit.java.spring.mvc.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.EmployeeDao;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.model.Position;

import java.util.List;

public class HEmployeeDao implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    @Transactional
    public Employee findByName(String name) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name"); // :name - параметр, переданный в запрос
        query.setParameter("name", name); // "name" должен совпадать с параметром в квери - :name
        return (Employee) query.uniqueResult();
    }
    @Override
    @Transactional
    public Employee findBySurname(String surname) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.surname like :surname"); // :name - параметр, переданный в запрос
        query.setParameter("surname", surname); // "name" должен совпадать с параметром в квери - :name
        return (Employee) query.uniqueResult();
    }
    @Override
    @Transactional
    public Employee findByNameAndSurname(String name, String surname) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name and e.surname like :surname"); // :name - параметр, переданный в запрос
        query.setParameter("name", name);
        query.setParameter("surname", surname); // "name" должен совпадать с параметром в квери - :name
        return (Employee) query.uniqueResult();
    }

    @Override
    @Transactional
    public void removeAllEmployees() {
        sessionFactory.getCurrentSession().createQuery("delete from Employee").executeUpdate();
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list();   // select* from employee

    }
    @Override
    @Transactional
    public List<Employee> findAllNamesAndSurnames() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e.name, e.surname from Employee e").list();
    }
    @Override
    @Transactional
    public List<Employee> findAllWaiters(Position position) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.position like :position"); // :name - параметр, переданный в запрос
        query.setParameter("position", position); // "name" должен совпадать с параметром в квери - :name
        return query.getResultList();

//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("select e from Employee e where e.position =WAITER").list();   // select* from employee

    }

    @Override
    @Transactional
    public Employee getById(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Employee e where e.id = :id");
        query.setParameter("id", id);
        Employee result = (Employee) query.uniqueResult();
        if (result == null) {
            throw new RuntimeException("Employee was not fount by id = " + id);
        }
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
        @Override
    @Transactional
    public Employee load(Long id) {
        return sessionFactory.getCurrentSession().load(Employee.class, id);
    }
}
