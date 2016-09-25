package ua.joit.java.spring.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.joit.java.spring.mvc.service.OrderService;

@Controller
public class OrderController {

    private OrderService orderService;

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET) // show all
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "admin/order/orders";
    }



    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
