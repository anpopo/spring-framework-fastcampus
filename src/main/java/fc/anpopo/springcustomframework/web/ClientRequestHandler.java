package fc.anpopo.springcustomframework.web;

import fc.anpopo.springcustomframework.calculator.Calculator;
import fc.anpopo.springcustomframework.calculator.PositiveNumber;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record ClientRequestHandler(Socket client) implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(ClientRequestHandler.class);

    @Override
    public void run() {
        log.info("[ClientRequestHandler] new client {} started.", Thread.currentThread().getName());

        try (
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(os);
        ) {
            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isRequestEqualsMethod("GET") && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int op1 = Integer.parseInt(queryStrings.getValue("op1"));
                String op = queryStrings.getValue("op");
                int op2 = Integer.parseInt(queryStrings.getValue("op2"));

                int result = Calculator.calculateV4(new PositiveNumber(op1), op, new PositiveNumber(op2));
                byte[] body = String.valueOf(result).getBytes(StandardCharsets.UTF_8);

                HttpResponse response = new HttpResponse(dos);
                response.response200Header("application/json", body.length);
                response.responseBody(body);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

    }
}
