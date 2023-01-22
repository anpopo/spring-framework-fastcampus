package fc.anpopo.springcustomframework.mvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

public class RedirectView implements View{

    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private final String redirectPath;

    public RedirectView(String redirectPath) {
        this.redirectPath = redirectPath;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
        res.sendRedirect(redirectPath.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }
}
