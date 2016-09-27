package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Ingredient;
import ua.joit.java.spring.mvc.service.DishService;
import ua.joit.java.spring.mvc.service.IngredientService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class DishController {

    private DishService dishService;
    private IngredientService ingredientService;

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public ModelAndView dish(@RequestParam("dishName") String dishName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("dish", dishService.getDishByName(dishName)); // добав как в мапу
        modelAndView.setViewName("client-app/dish/dish"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }

    @RequestMapping(value = "/dishes", method = RequestMethod.GET) // link to JSP
    public String dish(Map<String, Object> model) {

        model.put("dishes", dishService.getDishes());

        return "client-app/dish/dishes";  // возвращаем JSP
    }
    @RequestMapping(value = "/dishes/find", method = RequestMethod.GET)
    public String finfByName(@RequestParam("name") String name, ModelMap modelMap) {
        if (name==null || name=="") {
            return "redirect:/";
        } else {
            Dish dish = dishService.findByName(name);
            modelMap.addAttribute("dish", dish);
            return "/client-app/dish/findByName";
        }
    }

//    ------------------------------------
@RequestMapping(value = "/admin/dishes", method = RequestMethod.GET) // show all
public String showAllDishes(Model model) {
    model.addAttribute("dishes", dishService.getDishes());
    return "admin/dish/dishes";
}

    @RequestMapping(value = "/admin/dishes", method = RequestMethod.POST) // add menu
    public String saveOrUpdateDish(@ModelAttribute("dishForm") @Validated Dish dish, BindingResult result){
        if(result.hasErrors()) {
            return "admin/dish/form";
        }
        dishService.save(dish);

        return "redirect:/admin/dishes";
    }

    @RequestMapping(value = "/admin/dishes/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {

        Dish dish = new Dish();

        model.addAttribute("dishForm", dish);

        return "admin/dish/form";

    }

    @RequestMapping(value = "/admin/dishes/dish/{id}", method = RequestMethod.GET)
    public ModelAndView Menu(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        Dish dish = dishService.getById(id);
        modelAndView.addObject("dish", dish);

        List<Ingredient> ingredientList = dish.getIngredients();

        modelAndView.addObject("ingredientList", ingredientList);

        modelAndView.addObject("ingredient", new Ingredient());


        Map<Ingredient, String> ingredientNameList = new HashMap<>();
        for (Ingredient ingredient: ingredientService.getIngredients()){
            ingredientNameList.put(ingredient, ingredient.getName());
        }
        modelAndView.addObject("ingredientNameList", ingredientNameList);

        modelAndView.setViewName("/admin/dish/dish");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/dishes/{id}/delete", method = RequestMethod.GET)
    public String deleteMenu(@PathVariable("id") Long id){
        dishService.removeDish(dishService.getById(id));
        return "redirect:/admin/dishes";
    }

    @RequestMapping(value = "/admin/dishes/{id}/update", method = RequestMethod.GET)
    public String updateDish(@PathVariable Long id, Model model) {
        Dish dish = dishService.getById(id);
        model.addAttribute("dishForm", dish);
        return "admin/dish/form";
    }

    @RequestMapping(value = "/admin/dishes/{id}/addIngredient", method = RequestMethod.POST)
    public String addIngredientToDish(@PathVariable("id") Long id, @ModelAttribute("ingredient") Ingredient ingredient) {
        String ingredientName = ingredient.getName();
        Ingredient actualIngredient = ingredientService.getIngredientByName(ingredientName);
        Dish dish = dishService.getById(id);
        dish.getIngredients().add(actualIngredient);
        dishService.save(dish);

        System.out.println(dish.toString());

        return "redirect:/admin/dishes/dish/" + dish.getId();
    }

    @RequestMapping(value = "/admin/dishes/{dishId}/deleteIngredient/{ingredientId}", method = RequestMethod.GET)
    public String deleteIngredientFromDish(@PathVariable("dishId") Long dishId, @PathVariable("ingredientId") Long ingredientId) {
        Dish dish = dishService.getById(dishId);
        List<Ingredient> ingredients = dish.getIngredients();
        Iterator<Ingredient> iterator = ingredients.iterator();
        while (iterator.hasNext()) {
            Ingredient ingredient = iterator.next();
            if(ingredient.getId()==ingredientId) {
                iterator.remove();
            }
        }
        dishService.save(dish);
        return "redirect:/admin/dishes/dish/" + dish.getId();
    }




@Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }
}
