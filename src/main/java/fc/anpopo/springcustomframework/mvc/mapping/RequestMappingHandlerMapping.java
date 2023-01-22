package fc.anpopo.springcustomframework.mvc.mapping;

import fc.anpopo.springcustomframework.mvc.handler.Handler;
import fc.anpopo.springcustomframework.mvc.controller.ForwardController;
import fc.anpopo.springcustomframework.mvc.handler.HandlerKey;
import fc.anpopo.springcustomframework.mvc.handler.RequestMethod;
import fc.anpopo.springcustomframework.mvc.controller.UserCreateController;
import fc.anpopo.springcustomframework.mvc.controller.UserListController;
import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping implements HandlerMapping {

    private Map<HandlerKey, Handler> mapping = new HashMap<>();

    public void init() {
        mapping.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mapping.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        mapping.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));
    }

    public Handler findHandler(HandlerKey handlerKey) {
        return mapping.get(handlerKey);
    }

}
