package ua.joit.java.spring.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
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
        return employeeService.findAllNamesAndSurnames();
    }

    @RequestMapping(value = "/rest/employeeAll/{employeeName}", method = RequestMethod.GET)
    public Employee empl(@PathVariable String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }

    @RequestMapping(value = "/rest/employees/findName", method = RequestMethod.GET)
    public Employee findByName(@RequestParam("name") String name, ModelMap modelMap) {

        return employeeService.getEmployeeByName(name);

    }
    @RequestMapping(value = "/rest/employees/findNameAndSurname", method = RequestMethod.GET)
    public Employee findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname, ModelMap modelMap) {

        return employeeService.getEmployeeByNameAndSurname(name, surname);

    }
    @RequestMapping(value = "/rest/employees/findSurname", method = RequestMethod.GET)
    public Employee findBySurname(@RequestParam("surname") String surname, ModelMap modelMap) {

        return employeeService.getEmployeeBySurname(surname);

    }
    @RequestMapping(value = "/rest/employees/findId", method = RequestMethod.GET)
    public Employee findById(@RequestParam("id") Long id, ModelMap modelMap) {
    return employeeService.getById(id);

    }
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
