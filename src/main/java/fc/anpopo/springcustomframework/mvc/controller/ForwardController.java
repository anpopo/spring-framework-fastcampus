package fc.anpopo.springcustomframework.mvc.controller;

import fc.anpopo.springcustomframework.mvc.handler.Handler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForwardController implements Handler {

    private final String forwardUriPath;

    public ForwardController(String forwardUriPath) {
        this.forwardUriPath = forwardUriPath;
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return forwardUriPath;
    }
}
