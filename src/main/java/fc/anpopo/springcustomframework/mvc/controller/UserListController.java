package fc.anpopo.springcustomframework.mvc.controller;

import fc.anpopo.springcustomframework.mvc.handler.Handler;
import fc.anpopo.springcustomframework.mvc.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserListController implements Handler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }
}
