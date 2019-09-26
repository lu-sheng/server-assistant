package com.feidao.server.assistant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * LN
 * 2019/9/10 0010 10:08
 */
//@ImportResource("classpath:/application.yml")
@SpringBootApplication
@RestController
@EnableSwagger2    //访问127.0.0.1:9090/swagger-ui.html
@MapperScan("com.feidao.server.assistant.mapper")
public class AssistantApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssistantApplication.class, args);
    }

    @GetMapping("/hello")
    private String hello() {
        return "hello spring security";
    }
}
