package ua.joit.java.spring.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.joit.java.spring.mvc.model.Menu;
import ua.joit.java.spring.mvc.service.DishService;
import ua.joit.java.spring.mvc.service.MenuService;

import java.util.List;


@RestController
public class RestMenuController {

    private MenuService menuService;
    private DishService dishService;

    @RequestMapping(value = "/rest/menus", method = RequestMethod.GET) // show all
    public List<Menu> showAllMenus(Model model) {
        return menuService.findAllNames();
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
