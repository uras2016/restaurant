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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    private MenuService menuService;
    private DishService dishService;

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

    @RequestMapping(value = "/menus/edit", method = RequestMethod.GET) // link to JSP
    public String menusAll(Map<String, Object> model) {

        model.put("menusE", menuService.getMenus());

        return "admin/menu/old/menusEdit";  // возвращаем JSP
    }

    @RequestMapping(value = "menus/forEdit", method = RequestMethod.GET)
    public String showAddUserForm(Model model){
        Menu menu = new Menu();
        model.addAttribute("menus", menuService.getMenus());

        return "admin/menu/old/forEdit";
    }



    @RequestMapping(value = "/menus/show/{menuName}", method = RequestMethod.GET)
    public ModelAndView showMenu(@PathVariable String menuName) {
        ModelAndView modelAndView = new ModelAndView();

        Menu menu = menuService.getMenuByName(menuName);
        modelAndView.addObject("menu", menu);

        List<Dish> dishList = menu.getDishes();
        modelAndView.addObject("dishList", dishList);

        modelAndView.addObject("dish", new Dish());


        Map<Dish, String> dishNameList = new HashMap<>();
        for (Dish dish: dishService.getDishes()){
            dishNameList.put(dish, dish.getName());
        }
        modelAndView.addObject("dishNameList", dishNameList);

        modelAndView.setViewName("admin/menu/old/show");
        return modelAndView;
    }
//-------------------------------------------------

    @RequestMapping(value = "/admin/menus", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("menus", menuService.getMenus());
        return "admin/menu/menus";

    }
    @RequestMapping(value = "/admin/menus", method = RequestMethod.POST)
    public String saveOrUpdateMenu(@ModelAttribute("menuForm") @Validated Menu menu, BindingResult result){
        if(result.hasErrors()) {
            return "admin/menu/form";
        }
        menuService.add(menu);

        return "redirect:/admin/menus";
    }
    @RequestMapping(value = "/admin/menus/add", method = RequestMethod.GET)
    public String showAddMenuForm(Model model) {

        Menu menu = new Menu();

        model.addAttribute("menuForm", menu);

        return "admin/menu/form";

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

