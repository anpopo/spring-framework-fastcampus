package fc.anpopo.springcustomframework.mvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public interface View {

    void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res) throws Exception;


}
