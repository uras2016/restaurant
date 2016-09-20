package ua.joit.java.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SchemaController {

    @RequestMapping(value = "/schema", method = RequestMethod.GET)
    public String schema() {
        return "client-app/schema";
    }

}
