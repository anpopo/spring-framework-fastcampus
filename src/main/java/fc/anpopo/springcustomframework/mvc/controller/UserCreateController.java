package fc.anpopo.springcustomframework.mvc.controller;

import fc.anpopo.springcustomframework.mvc.handler.Handler;
import fc.anpopo.springcustomframework.mvc.model.User;
import fc.anpopo.springcustomframework.mvc.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserCreateController implements Handler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        UserRepository.save(new User(request.getParameter("userId"), request.getParameter("name")));
        return "redirect:/users";
    }

}
