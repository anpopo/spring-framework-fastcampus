package fc.anpopo.springcustomframework.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {

    private final List<QueryString> queryStrings = new ArrayList<>();
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&");

        Arrays.stream(queryStringTokens)
            .forEach(s -> {
                String[] values = s.split("=");
                if (values.length < 2) {
                    throw new IllegalArgumentException("잘못된 문자열 요청입니다.");
                }

                queryStrings.add(new QueryString(values[0], values[1]));
            });
    }

    public String getValue(String key) {
        return this.queryStrings.stream()
            .filter(queryString -> queryString.isMatchKey(key))
            .map(QueryString::getValue)
            .findFirst()
            .orElse(null);
    }
}
