package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.service.IngredientService;

import java.util.Map;

@Controller
public class IngredientController {

    private IngredientService ingredientService;

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET) // link to JSP
    public String ingredient(Map<String, Object> model) {

        model.put("ingredients", ingredientService.getIngredients());

        return "client-app/ingredients";  // возвращаем JSP
    }

    @RequestMapping(value = "/ingredients/edit", method = RequestMethod.GET) // link to JSP
    public String ingredientAll(Map<String, Object> model) {

        model.put("ingredientsE", ingredientService.getIngredients());

        return "client-app/ingredientsEdit";  // возвращаем JSP
    }

    @RequestMapping(value = "/ingredient", method = RequestMethod.GET)
    public ModelAndView ingredient(@RequestParam("ingredientName") String ingredientName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredient", ingredientService.getIngredientByName(ingredientName)); // добав как в мапу
        modelAndView.setViewName("client-app/ingredient"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }






    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

}
