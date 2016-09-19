package ua.joit.java.spring.mvc.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsController {
    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String contacts() {
        return "/contacts";
    }
}
