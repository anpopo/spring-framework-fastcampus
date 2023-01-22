package fc.anpopo.springcustomframework.mvc.mapping;

import fc.anpopo.springcustomframework.mvc.handler.AnnotationHandler;
import fc.anpopo.springcustomframework.mvc.annotation.Controller;
import fc.anpopo.springcustomframework.mvc.annotation.RequestMapping;
import fc.anpopo.springcustomframework.mvc.handler.HandlerKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;

public class AnnotationHandlerMapping implements HandlerMapping{

    private final Object[] basePackage;

    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }

    public void initialize() {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> controllerAnnotationClasses = reflections.getTypesAnnotatedWith(Controller.class);

        controllerAnnotationClasses.forEach(c -> {
            Arrays.stream(c.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(RequestMapping.class))
                .forEach(m -> {
                    RequestMapping requestMappingAnnotation = m.getAnnotation(RequestMapping.class);

                    handlers.put(
                        new HandlerKey(requestMappingAnnotation.requestMethod(), requestMappingAnnotation.value()),
                        new AnnotationHandler(c, m)
                    );
                });
        });


    }

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }
}
