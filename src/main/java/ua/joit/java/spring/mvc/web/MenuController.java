package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Menu;
import ua.joit.java.spring.mvc.service.DishService;
import ua.joit.java.spring.mvc.service.MenuService;

import java.io.IOException;
import java.util.*;

@Controller
public class MenuController {

    private MenuService menuService;
    private DishService dishService;

    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(IOException exception) {
        ModelAndView modelAndView = new ModelAndView("/exception/catchedException");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ModelAndView menu(@RequestParam("menuName") String menuName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menu", menuService.getMenuByName(menuName)); // добав как в мапу
        modelAndView.setViewName("client-app/menu/menu"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }

    @RequestMapping(value = "/menus", method = RequestMethod.GET) // link to JSP
    public String menus(Map<String, Object> model) {

        model.put("menus", menuService.getMenus());

        return "client-app/menu/menus";  // возвращаем JSP
    }

//-------------------------------------------------

    @RequestMapping(value = "/admin/menus", method = RequestMethod.GET) // show all
    public String showAllUsers(Model model) {
        model.addAttribute("menus", menuService.getMenus());
        return "admin/menu/menus";

    }

    @RequestMapping(value = "/admin/menus", method = RequestMethod.POST) // add menu
    public String saveOrUpdateMenu(@ModelAttribute("menuForm") @Validated Menu menu, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/menu/form";
        }
        menuService.add(menu);

        return "redirect:/admin/menus";
    }

    @RequestMapping(value = "/admin/menus/menu/{id}", method = RequestMethod.GET)
    public ModelAndView Menu(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        Menu menu = menuService.getById(id);
        modelAndView.addObject("menu", menu);

        List<Dish> dishList = menu.getDishes();

        modelAndView.addObject("dishList", dishList);

        modelAndView.addObject("dish", new Dish());


        Map<Dish, String> dishNameList = new HashMap<>();
        for (Dish dish : dishService.getDishes()) {
            dishNameList.put(dish, dish.getName());
        }
        modelAndView.addObject("dishNameList", dishNameList);

        modelAndView.setViewName("/admin/menu/menu");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/menus/add", method = RequestMethod.GET)
    public String showAddMenuForm(Model model) {

        Menu menu = new Menu();

        model.addAttribute("menuForm", menu);

        return "admin/menu/form";

    }

    @RequestMapping(value = "/admin/menus/{id}/delete", method = RequestMethod.GET)
    public String deleteMenu(@PathVariable("id") Long id) {
        menuService.remove(menuService.getById(id));
        return "redirect:/admin/menus";
    }

    @RequestMapping(value = "/admin/menus/{id}/update", method = RequestMethod.GET)
    public String updateMenu(@PathVariable Long id, Model model) {
        Menu menu = menuService.getById(id);
        model.addAttribute("menuForm", menu);
        return "/admin/menu/form";
    }


    @RequestMapping(value = "/admin/menus/{id}/addDish", method = RequestMethod.POST)
    public String addDishToMenu(@PathVariable("id") Long id, @ModelAttribute("dish") Dish dish) {
        String dishName = dish.getName();
        Dish actualDish = dishService.findByName(dishName);
        Menu menu = menuService.getById(id);
        menu.getDishes().add(actualDish);
        menuService.add(menu);

        return "redirect:/admin/menus/menu/" + menu.getId();
    }

    @RequestMapping(value = "/admin/menus/{menuId}/deleteDish/{dishId}", method = RequestMethod.GET)
    public String deleteDishFromMenu(@PathVariable("menuId") Long menuId, @PathVariable("dishId") Long dishId) {
        Menu menu = menuService.getById(menuId);
        List<Dish> dishes = menu.getDishes();
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (dish.getId() == dishId) {
                iterator.remove();
            }
        }
        menuService.add(menu);
        return "redirect:/admin/menus/menu/" + menu.getId();
    }


    @RequestMapping(value = "/", method = RequestMethod.GET) // show all
    public String showAllm(Model model) {
        model.addAttribute("menus", menuService.getMenus());
        model.addAttribute("currentTime", new Date().toString());
        return "index";

    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}

