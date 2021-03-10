package com.course.wang.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.course.wang.exception.core.ExceptionBuilder;

/**
 * @author Wangjunlei
 * @date 2021/3/10 7:30 下午
 */

public class BaseService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ExceptionBuilder exceptionBuilder;

    public BaseService() {
    }
}
