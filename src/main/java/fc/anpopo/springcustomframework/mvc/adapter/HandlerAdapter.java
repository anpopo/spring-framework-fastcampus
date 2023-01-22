package fc.anpopo.springcustomframework.mvc.adapter;

import fc.anpopo.springcustomframework.mvc.model.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface HandlerAdapter {

    boolean supports(Object handler);

    ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws  Exception;



}
