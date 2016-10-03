package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {

        model.put("employees", employeeService.getWaiters());

        return "client-app/employee/employees";  // возвращаем JSP
    }

        @RequestMapping(value = "/employeesAll", method = RequestMethod.GET)
    public String employeesAll(Map<String, Object> model) {

        model.put("employees", employeeService.getEmployees());

        return "client-app/employee/employeesAll";  // возвращаем JSP
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employee(@RequestParam("employeeName") String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeByName(employeeName)); // добав как в мапу
        modelAndView.setViewName("client-app/employee/employee"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }

//    ------------------for admin------------------------

    @RequestMapping(value = "/admin/employees", method = RequestMethod.GET) // show all
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "admin/employee/employees";
    }

    @RequestMapping(value = "/admin/employees", method = RequestMethod.POST) // add employee
    public String saveOrUpdateEmployee(@ModelAttribute("employeeForm") @Validated Employee employee, BindingResult result)  {
        if (result.hasErrors()) {
            System.out.println("what are you writing, Man?!");

                return "admin/employee/form";

        }
        employeeService.save(employee);

        return "redirect:/admin/employees";
    }

    @RequestMapping(value = "/admin/employees/add", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employeeForm", employee);

        return "admin/employee/form";

    }

    @RequestMapping(value = "/admin/employees/employee/{id}", method = RequestMethod.GET)
    public ModelAndView Menu(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        Employee employee = employeeService.getById(id);
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("/admin/employee/employee");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/employees/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.remove(employeeService.getById(id));
        return "redirect:/admin/employees";
    }

    @RequestMapping(value = "/admin/employees/{id}/update", method = RequestMethod.GET)
    public String updateEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employeeForm", employee);
        return "admin/employee/form";
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

        ModelAndView model = new ModelAndView();
        model.setViewName("admin/employee/employee");
        model.addObject("msg", "user not found");

        return model;
    }
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
