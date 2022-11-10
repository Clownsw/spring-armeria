package cn.smilex.service;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import org.springframework.stereotype.Component;

/**
 * @author smilex
 * @date 2022/11/10/21:24
 * @since 1.0
 */
@SuppressWarnings("unused")
@Component
public class HelloService {

    @Get("/welcome/:userName")
    public HttpResponse welcome(@Param("userName") String userName) {
        return HttpResponse.builder()
                .status(HttpStatus.OK)
                .content(MediaType.PLAIN_TEXT_UTF_8, String.format("Hello %s", userName))
                .build();
    }
}
