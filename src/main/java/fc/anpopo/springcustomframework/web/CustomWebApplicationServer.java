package fc.anpopo.springcustomframework.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWebApplicationServer {

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private final int port;

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

                // 사용자 요청시마다 계속해서 thread 를 생성?! -> 독립적인 메모리 생성해서 사용
                // cpu 의 컨텍스트 스위칭 + 메모리 비용 증가 -> 서버 리소스의 과부하..
//                new Thread(new ClientRequestHandler(clientSocket)).start();

                // thread pool 을 사용해 스레드 리소스의 한계를 적용 및 최적화
                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
