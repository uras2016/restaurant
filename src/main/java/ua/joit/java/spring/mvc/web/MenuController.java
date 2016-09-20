package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.service.MenuService;

import java.util.Map;

@Controller
public class MenuController {

    private MenuService menuService;

    @RequestMapping(value = "/menus", method = RequestMethod.GET) // link to JSP
    public String menus(Map<String, Object> model) {

        model.put("menus", menuService.getMenus());

        return "client-app/index";  // возвращаем JSP
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ModelAndView menu(@RequestParam("menuName") String menuName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("menu", menuService.getMenuByName(menuName)); // добав как в мапу
        modelAndView.setViewName("client-app/menu"); // логическое имя модели
        return modelAndView;  // возвращаем JSP
    }


    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
