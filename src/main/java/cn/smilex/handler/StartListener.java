package cn.smilex.handler;

import cn.smilex.service.HelloService;
import com.linecorp.armeria.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author smilex
 * @date 2022/11/10/21:37
 * @since 1.0
 */
@Component
public class StartListener {
    private HelloService helloService;

    @Autowired
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public void start() {
        Server server = Server.builder()
                .http(8888)
                .annotatedService(helloService)
                .build();

        server.start()
                .join();
    }
}
