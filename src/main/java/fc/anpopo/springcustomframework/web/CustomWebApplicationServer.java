package fc.anpopo.springcustomframework.web;

import fc.anpopo.springcustomframework.calculator.Calculator;
import fc.anpopo.springcustomframework.calculator.PositiveNumber;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWebApplicationServer {

    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port", port);
            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected.");

                try (
                    InputStream is = clientSocket.getInputStream();
                    OutputStream os = clientSocket.getOutputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
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
                }
            }
        }
    }

}
