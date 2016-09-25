package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.service.EmployeeService;

import java.util.Map;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(Map<String, Object> model) {

        model.put("employees", employeeService.getEmployees());

        return "client-app/employee/employees";  // возвращаем JSP
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ModelAndView employee(@RequestParam("employeeName") String employeeName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employeeService.getEmployeeByName(employeeName)); // добав как в мапу
        modelAndView.setViewName("client-app/employee/employee"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }

//    ------------------------------------------

    @RequestMapping(value = "/admin/employees", method = RequestMethod.GET) // show all
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "admin/employee/employees";
    }




    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
