package fc.anpopo.springcustomframework.web;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {

    private final RequestLine requestLine;

    public HttpRequest(BufferedReader bufferedReader) throws IOException {
        this.requestLine = new RequestLine(bufferedReader.readLine());
    }

    public boolean isRequestEqualsMethod(String method) {
        return requestLine.isRequestEqualsMethod(method);
    }

    public boolean matchPath(String path) {
        return requestLine.matchPath(path);
    }

    public QueryStrings getQueryStrings() {
        return requestLine.getQueryStrings();
    }
}
