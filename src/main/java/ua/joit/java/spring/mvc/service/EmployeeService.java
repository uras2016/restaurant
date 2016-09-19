package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.EmployeeDao;
import ua.joit.java.spring.mvc.model.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    @Transactional
    public List<Employee> getEmployees(){
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name){
        return employeeDao.findByName(name);
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
