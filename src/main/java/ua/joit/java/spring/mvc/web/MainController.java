package ua.joit.java.spring.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@Controller/*(value = "/")*/
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)        //редирект риквеста на этот метод
    public String index(Map<String, Object> model){   // имя обьекта + сам обьект
        model.put("currentTime", new Date().toString()); // currentTime - название, по которому будем запускать
        return "client-app/index";                         // будет возвращать первую страничку приложения
    }



}
