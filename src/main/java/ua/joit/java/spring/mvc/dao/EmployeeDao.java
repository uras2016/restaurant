package ua.joit.java.spring.mvc.dao;

import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.model.Position;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);
    void remove(Employee employee);
    Employee findByName(String name);
    List<Employee> findAll();
    public List<Employee> findAllWaiters(Position position);

    void removeAllEmployees();

    Employee getById(Long id);

    Employee load(Long id);

}
