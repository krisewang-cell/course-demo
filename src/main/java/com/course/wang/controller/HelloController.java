package com.course.wang.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.wang.exception.CommonException;
import com.course.wang.service.user.UserService;

/**
 * @author Wangjunlei
 * @apiNote 测试
 * @date 2021/3/10 11:31 上午
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        try {
            userService.errorTest();
        } catch (CommonException e) {
            logger.error("ErrorNo:{}, Message:{}", e.getErrorBuildResult().getErrorCode()
            , e.getErrorBuildResult().getErrorMessage());
        }

        return "Hello World";
    }
}
