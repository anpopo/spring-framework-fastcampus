package fc.anpopo.springcustomframework.mvc.controller;

import fc.anpopo.springcustomframework.mvc.annotation.Controller;
import fc.anpopo.springcustomframework.mvc.annotation.RequestMapping;
import fc.anpopo.springcustomframework.mvc.handler.RequestMethod;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController{

    @RequestMapping(value = "/", requestMethod = RequestMethod.GET)
    public String gethome(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
