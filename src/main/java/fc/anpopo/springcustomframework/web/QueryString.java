package fc.anpopo.springcustomframework.web;

public class QueryString {


    private final String key;
    private final String value;

    public QueryString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean isMatchKey(String value) {
        return this.key.equals(value);
    }

    public String getValue() {
        return this.value;
    }
}
