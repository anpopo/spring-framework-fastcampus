package fc.anpopo.springcustomframework.mvc.handler;

public enum RequestMethod {
    GET, POST, PUT, DELETE;

    public static RequestMethod find(String method) {
        return valueOf(method);
    }
}
