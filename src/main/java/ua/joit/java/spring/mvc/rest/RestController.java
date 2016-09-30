package ua.joit.java.spring.mvc.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {


        @RequestMapping(value = "/rest", method = RequestMethod.GET)
        public String contacts() {
            return "rest/rest";
        }

}
