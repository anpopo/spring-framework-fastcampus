package fc.anpopo.springcustomframework.mvc.adapter;

import fc.anpopo.springcustomframework.mvc.handler.AnnotationHandler;
import fc.anpopo.springcustomframework.mvc.model.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AnnotationHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean supports(Object handler) {
        return handler instanceof AnnotationHandler;
    }

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String viewName = ((AnnotationHandler) handler).handleRequest(req, res);
        return new ModelAndView(viewName);
    }
}
