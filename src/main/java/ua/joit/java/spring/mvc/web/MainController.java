package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.service.DishService;

import java.util.Date;
import java.util.Map;

@Controller/*(value = "/")*/
public class MainController {

    private DishService dishService;

    @RequestMapping(value = "/", method = RequestMethod.GET)        //редирект риквеста на этот метод
    public String index(Map<String, Object> model){   // имя обьекта + сам обьект
        model.put("currentTime", new Date().toString()); // currentTime - название, по которому будем запускать
        return "index";                         // будет возвращать первую страничку приложения
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String searchByName(@RequestParam("name") String name, ModelMap modelMap) {
        if (name==null || name=="") {
            return "redirect:/";
        } else {
            Dish dish = dishService.findByName(name);
            modelMap.addAttribute("dishes", dish);
            return "/find";
        }
    }

    @RequestMapping(value = "/find/{dishName}", method = RequestMethod.GET)
    public ModelAndView showDish(@PathVariable String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        Dish dish = dishService.findByName(dishName);
        modelAndView.addObject(dish);

        modelAndView.addObject("ingredients", dish.getIngredients());

        modelAndView.setViewName("/dish");
        return modelAndView;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
