package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.service.DishService;

import java.util.Map;

@Controller
public class DishController {

    private DishService dishService;

    @RequestMapping(value = "/dishes", method = RequestMethod.GET) // link to JSP
    public String dish(Map<String, Object> model) {

        model.put("dishes", dishService.getDishes());

        return "client-app/dish/dishes";  // возвращаем JSP
    }

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView dish(@RequestParam("dishName") String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishByName(dishName)); // добав как в мапу
        modelAndView.setViewName("client-app/dish/dish"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
