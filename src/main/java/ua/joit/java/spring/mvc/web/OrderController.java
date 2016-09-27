package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Orders;
import ua.joit.java.spring.mvc.service.DishService;
import ua.joit.java.spring.mvc.service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    private OrderService orderService;
    private DishService dishService;

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET) // show all
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "admin/order/orders";
    }

    @RequestMapping(value = "/admin/orders/order/{id}", method = RequestMethod.GET)
    public ModelAndView Menu(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        Orders order = orderService.getById(id);
        modelAndView.addObject("order", order);

        List<Dish> dishList = order.getDishes();

        modelAndView.addObject("dishList", dishList);

        modelAndView.addObject("dish", new Dish());


        Map<Dish, String> dishNameList = new HashMap<>();
        for (Dish dish: dishService.getDishes()){
            dishNameList.put(dish, dish.getName());
        }
        modelAndView.addObject("dishNameList", dishNameList);

        modelAndView.setViewName("/admin/order/order");
        return modelAndView;
    }

    @ModelAttribute("dishes")
    public List<String> getDishesNames() {
        List<String> dishes = new ArrayList<>();
        for (Dish dish : dishService.getDishes()) {
            dishes.add(dish.getName());
        }
        return dishes;
    }

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
