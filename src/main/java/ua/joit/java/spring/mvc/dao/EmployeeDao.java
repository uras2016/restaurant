package ua.joit.java.spring.mvc.dao;

import ua.joit.java.spring.mvc.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);
    void remove(Employee employee);
    Employee findByName(String name);
    List<Employee> findAll();

    void removeAllEmployees();

        Employee load(Long id);

}
