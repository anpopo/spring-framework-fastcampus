package fc.anpopo.springcustomframework.web;

import java.io.IOException;

public class WebServerMain {

    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }

}
