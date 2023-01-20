package fc.anpopo.springcustomframework.web;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpResponse {

    private static final Logger logger = LoggerFactory.getLogger(HttpResponse.class);
    private final DataOutputStream dos;

    public HttpResponse(DataOutputStream dos) {
        this.dos = dos;
    }

    public void response200Header(String contentType, int length) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK\n");
            dos.writeBytes(String.format("Content-Type:%s;charset=utf-8\n", contentType));
            dos.writeBytes(String.format("Content-Length:%d\n", length));
            dos.writeBytes("\n");

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void responseBody(byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
