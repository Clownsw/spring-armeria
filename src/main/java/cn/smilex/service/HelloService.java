package cn.smilex.service;

import cn.smilex.entity.Result;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author smilex
 * @date 2022/11/10/21:24
 * @since 1.0
 */
@SuppressWarnings("unused")
@Component
public class HelloService {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Get("/welcome/:userName")
    public HttpResponse welcome(@Param("userName") String userName) {
        return HttpResponse.builder()
                .status(HttpStatus.OK)
                .content(MediaType.PLAIN_TEXT_UTF_8, String.format("Hello %s", userName))
                .build();
    }

    @Get("/selectAllStudent")
    public HttpResponse selectAllStudent() {
        return HttpResponse.ofJson(new Result<>(200, "success", studentService.list()));
    }
}
