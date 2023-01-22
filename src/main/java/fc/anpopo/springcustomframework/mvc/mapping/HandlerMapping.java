package fc.anpopo.springcustomframework.mvc.mapping;

import fc.anpopo.springcustomframework.mvc.handler.HandlerKey;

public interface HandlerMapping {

    Object findHandler(HandlerKey handlerKey);
}
