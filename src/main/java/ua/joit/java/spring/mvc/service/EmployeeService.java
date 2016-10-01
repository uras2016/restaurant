package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.EmployeeDao;
import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.model.Position;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getWaiters() {
        return employeeDao.findAllWaiters(Position.WAITER);
    }

    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }
    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Transactional
    public Employee getEmployeeBySurname(String surname) {
        return employeeDao.findBySurname(surname);
    }
    @Transactional
    public Employee getEmployeeByNameAndSurname(String name, String surname) {
        return employeeDao.findByNameAndSurname(name,surname);
    }
    @Transactional
    public Employee getById(Long id) {
        return employeeDao.getById(id);
    }
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }
    @Transactional
    public void remove(Employee employee) {
        employeeDao.remove(employee);
    }

    @Transactional
    public List<Employee> findAllNamesAndSurnames() {
        return employeeDao.findAllNamesAndSurnames();
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
