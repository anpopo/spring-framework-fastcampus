package fc.anpopo.springcustomframework.web;

import java.util.Objects;
import java.util.StringTokenizer;

public class RequestLine {

    private final String method;
    private final String urlPath;
    private String queryString;

    public RequestLine(String requestLine) {
        StringTokenizer st = new StringTokenizer(requestLine);
        this.method = st.nextToken();
        String[] path = st.nextToken().split("\\?");
        this.urlPath = path[0];

        if (path.length >= 2) {
            this.queryString = path[1];
        }
    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    public boolean isRequestEqualsMethod(String method) {
        return this.method.equalsIgnoreCase(method);
    }

    public boolean matchPath(String path) {
        return this.urlPath.equals(path);
    }

    public QueryStrings getQueryStrings() {
        return new QueryStrings(this.queryString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath)
            && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
