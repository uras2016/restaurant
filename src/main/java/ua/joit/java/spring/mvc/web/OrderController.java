package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.joit.java.spring.mvc.Exceptions.ProhibitionException;
import ua.joit.java.spring.mvc.model.Dish;
import ua.joit.java.spring.mvc.model.Orders;
import ua.joit.java.spring.mvc.model.Status;
import ua.joit.java.spring.mvc.service.DishService;
import ua.joit.java.spring.mvc.service.OrderService;

import java.util.*;

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

    @RequestMapping(value = "/admin/orders", method = RequestMethod.POST) // add menu
    public String saveOrUpdateOrder(@ModelAttribute("orderForm") @Validated Orders order, BindingResult result){
        if(result.hasErrors()) {
            return "admin/order/form";
        }
        orderService.add(order);

        return "redirect:/admin/orders";
    }

    @RequestMapping(value = "/admin/orders/{id}/delete", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("id") Long id){
        orderService.removeOrder(orderService.getById(id));
        return "redirect:/admin/orders";
    }
    @RequestMapping(value = "/admin/orders/{id}/close", method = RequestMethod.GET)
    public String closeOrder(@PathVariable("id") Long id){
        orderService.closeOrder(orderService.getById(id));
        return "redirect:/admin/orders";
    }

    @RequestMapping(value = "/admin/orders/{id}/addDish", method = RequestMethod.POST)
    public String addDishToOrder(@PathVariable("id") Long id, @ModelAttribute("dish") Dish dish) {
        String dishName = dish.getName();
        Dish actualDish = dishService.findByName(dishName);
        Orders order = orderService.getById(id);
        order.getDishes().add(actualDish);
        if (order.getStatus()== Status.CLOSE) {
            throw new ProhibitionException("Order was closed");
        }else {
            orderService.add(order);
        }

        return "redirect:/admin/orders/order/" + order.getId();
    }

    @RequestMapping(value = "/admin/orders/add", method = RequestMethod.GET)
    public String showAddDishForm(Model model) {

        Orders order = new Orders();

        model.addAttribute("orderForm", order);

        return "admin/order/form";

    }
    @RequestMapping(value = "/admin/orders/{orderId}/deleteDish/{dishId}", method = RequestMethod.GET)
    public String deleteDishFromOrder(@PathVariable("orderId") Long orderId, @PathVariable("dishId") Long dishId) {
        Orders order = orderService.getById(orderId);
        List<Dish> dishes = order.getDishes();
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (dish.getId() == dishId) {
                iterator.remove();
            }
        }
        if (order.getStatus()== Status.CLOSE) {
            throw new ProhibitionException("Order was closed");
        }else {
            orderService.add(order);
        }
        return "redirect:/admin/orders/order/" + order.getId();
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
