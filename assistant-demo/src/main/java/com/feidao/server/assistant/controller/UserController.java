package com.feidao.server.assistant.controller;


import com.feidao.server.assistant.entity.User;
import com.feidao.server.assistant.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LN
 * @since 2019-09-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private User register(@RequestBody User user) {
//        user.setId(12);
        userService.save(user);
        logger.info("添加用户成功：" + user.toString());
        return user;
    }
}
