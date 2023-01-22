package fc.anpopo.springcustomframework.mvc.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Handler {

    String handleRequest(HttpServletRequest request, HttpServletResponse response);

}
