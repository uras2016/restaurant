package ua.joit.java.spring.mvc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.joit.java.spring.mvc.model.Orders;
import ua.joit.java.spring.mvc.service.DishService;
import ua.joit.java.spring.mvc.service.OrderService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestOrderController {

    private OrderService orderService;
    private DishService dishService;

    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET) // show all
    public List<Orders> showAllOrders(Model model) {
        return orderService.findAllOrders();
    }
    @RequestMapping(value = "/rest/openOrders", method = RequestMethod.GET) // show all
    public List<Orders> showAllOpenOrders(Model model) {
        return orderService.findAllOpenedOrders();
    }
    @RequestMapping(value = "/rest/closedOrders", method = RequestMethod.GET) // show all
    public List<Orders> showAllClosedOrders(Model model) {
        return orderService.findAllClosedOrders();
    }

    @RequestMapping(value = "/rest/orders/findId", method = RequestMethod.GET)
    public Orders findById(@RequestParam("id") Long id, ModelMap modelMap) {

        return orderService.getById(id);

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


