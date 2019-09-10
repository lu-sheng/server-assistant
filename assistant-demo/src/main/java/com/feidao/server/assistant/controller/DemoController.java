package com.feidao.server.assistant.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LN
 * 2019/9/10 0010 10:27
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = "/hello")
    @ApiOperation(value = "测试")
    public String sayHelloWorld() {
        return "你好！";
    }
}
