package fc.anpopo.springcustomframework.mvc;

import fc.anpopo.springcustomframework.mvc.adapter.AnnotationHandlerAdapter;
import fc.anpopo.springcustomframework.mvc.adapter.HandlerAdapter;
import fc.anpopo.springcustomframework.mvc.adapter.SimpleControllerHandlerAdapter;
import fc.anpopo.springcustomframework.mvc.handler.HandlerKey;
import fc.anpopo.springcustomframework.mvc.handler.RequestMethod;
import fc.anpopo.springcustomframework.mvc.mapping.AnnotationHandlerMapping;
import fc.anpopo.springcustomframework.mvc.mapping.HandlerMapping;
import fc.anpopo.springcustomframework.mvc.mapping.RequestMappingHandlerMapping;
import fc.anpopo.springcustomframework.mvc.model.ModelAndView;
import fc.anpopo.springcustomframework.mvc.view.JspViewResolver;
import fc.anpopo.springcustomframework.mvc.view.View;
import fc.anpopo.springcustomframework.mvc.view.ViewResolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private List<HandlerMapping> handlerMappings;
    private List<ViewResolver> viewResolvers;
    private List<HandlerAdapter> handlerAdapters;

    @Override
    public void init() throws ServletException {
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
        requestMappingHandlerMapping.init();

        AnnotationHandlerMapping annotationHandlerMapping = new AnnotationHandlerMapping("fc.anpopo.springcustomframework.mvc");
        annotationHandlerMapping.initialize();

        handlerMappings = List.of(requestMappingHandlerMapping, annotationHandlerMapping);
        handlerAdapters = List.of(new SimpleControllerHandlerAdapter(), new AnnotationHandlerAdapter());
        viewResolvers = Collections.singletonList(new JspViewResolver());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HandlerKey handlerKey = new HandlerKey(RequestMethod.find(req.getMethod()), req.getRequestURI());

            Object handler = handlerMappings.stream()
                .filter(hm -> hm.findHandler(handlerKey) != null)
                .map(hm -> hm.findHandler(handlerKey))
                .findFirst()
                .orElseThrow(() -> new ServletException("No handler mapping."));

            HandlerAdapter handlerAdapter = handlerAdapters.stream()
                .filter(ha -> ha.supports(handler))
                .findFirst()
                .orElseThrow(() -> new ServletException("No handler adapter."));

            ModelAndView modelAndView = handlerAdapter.handle(req, resp, handler);

            for (ViewResolver viewResolver : viewResolvers) {
                View view = viewResolver.resolveView(modelAndView.getViewName());
                view.render(modelAndView.getModel(), req, resp);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
