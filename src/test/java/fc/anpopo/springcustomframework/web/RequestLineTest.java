package fc.anpopo.springcustomframework.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RequestLineTest {

    @Test
    void create() {
        RequestLine requestLine = new RequestLine("GET /calculate?op1=1&op=+&op2=11 HTTP/1.1");

        Assertions.assertThat(requestLine).isNotNull();
        Assertions.assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "op1=1&op=+&op2=11"));
    }

}
