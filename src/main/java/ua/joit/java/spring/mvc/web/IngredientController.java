package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.model.Ingredient;
import ua.joit.java.spring.mvc.service.IngredientService;

import java.util.Map;

@Controller
public class IngredientController {

    private IngredientService ingredientService;

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET) // link to JSP
    public String ingredient(Map<String, Object> model) {

        model.put("ingredients", ingredientService.getIngredients());

        return "client-app/ingredient/ingredients";  // возвращаем JSP
    }

    @RequestMapping(value = "/ingredients/edit", method = RequestMethod.GET) // link to JSP
    public String ingredientAll(Map<String, Object> model) {

        model.put("ingredientsE", ingredientService.getIngredients());

        return "client-app/ingredient/ingredientsEdit";  // возвращаем JSP
    }

    @RequestMapping(value = "/ingredient", method = RequestMethod.GET)
    public ModelAndView ingredient(@RequestParam("ingredientName") String ingredientName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ingredient", ingredientService.getIngredientByName(ingredientName)); // добав как в мапу
        modelAndView.setViewName("client-app/ingredient/ingredient"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }
//------------------for admin-----------

    @RequestMapping(value = "/admin/ingredients", method = RequestMethod.GET) // show all
    public String showAllIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getIngredients());
        return "admin/ingredients/ingredients";
    }


    @RequestMapping(value = "/admin/ingredients", method = RequestMethod.POST) // add menu
    public String saveOrUpdateIngredient(@ModelAttribute("form") @Validated Ingredient ingredient, BindingResult result){
        if(result.hasErrors()) {
            return "admin/ingredients/form";
        }

        ingredientService.addIngredient(ingredient);


        return "redirect:/admin/ingredients";
    }
    @RequestMapping(value = "/admin/ingredients/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {

        Ingredient ingredient = new Ingredient();

        model.addAttribute("form", ingredient);

        return "admin/ingredients/form";

    }

    @RequestMapping(value = "/admin/ingredients/{id}/delete", method = RequestMethod.GET)
    public String deleteIngredient(@PathVariable("id") Long id){
        ingredientService.removeIngredient(ingredientService.findById(id));
        return "redirect:/admin/ingredients";
    }




    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

}
