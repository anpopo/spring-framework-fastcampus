package fc.anpopo.springcustomframework.web;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueryStringsTest {

    private List<QueryString> queryStrings;

    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("op1=1&op=+&op2=11");

        Assertions.assertThat(queryStrings).isNotNull();
    }

}
