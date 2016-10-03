package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.Exceptions.ProhibitionException;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.service.DishService;

import javax.servlet.http.HttpServletRequest;

@Controller/*(value = "/")*/
public class MainController {

    private DishService dishService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)        //редирект риквеста на этот метод
//    public String index(Map<String, Object> model){   // имя обьекта + сам обьект
//        model.put("currentTime", new Date().toString()); // currentTime - название, по которому будем запускать
//        return "index";                         // будет возвращать первую страничку приложения
//    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String searchByName(@RequestParam("name") String name, ModelMap modelMap) {
        if (name == null || name == "") {
            return "redirect:/";
        } else {
            Dish dish = dishService.findByName(name);
            if (dish == null) {
                throw new ProhibitionException("There is no such dish.");
            } else {
                modelMap.addAttribute("dishes", dish);
                return "/find";
            }
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

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

        ModelAndView model = new ModelAndView();
        model.setViewName("/dish");
        model.addObject("msg", "dish not found");

        return model;
    }


    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
