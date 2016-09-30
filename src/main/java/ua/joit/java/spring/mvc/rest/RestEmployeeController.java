package ua.joit.java.spring.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
public class RestEmployeeController {

    private EmployeeService employeeService;


    @RequestMapping(value = "/rest/employees", method = RequestMethod.GET)
    public List<Employee> emplAll(Map<String, Object> model) {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/rest/employeeAll/{employeeName}", method = RequestMethod.GET)
    public Employee empl(@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }


    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
