package ua.joit.java.spring.mvc.dao;

import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.model.Position;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);
    void remove(Employee employee);
    Employee findByName(String name);
    List<Employee> findAll();

    List<Employee> findAllNamesAndSurnames();

    public List<Employee> findAllWaiters(Position position);

    Employee findBySurname(String surname);

    Employee findByNameAndSurname(String name, String surname);

    void removeAllEmployees();

    Employee getById(Long id);

    Employee load(Long id);

}
