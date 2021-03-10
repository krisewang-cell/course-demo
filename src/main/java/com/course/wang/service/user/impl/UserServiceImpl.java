package com.course.wang.service.user.impl;

/**
 * @author Wangjunlei
 * @date 2021/3/10 7:33 下午
 */

import org.springframework.stereotype.Service;

import com.course.wang.exception.core.ErrorConstants;
import com.course.wang.service.BaseService;
import com.course.wang.service.user.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public void errorTest() {
        logger.info("asdasdasd");
        throw exceptionBuilder.create(ErrorConstants.SUCCESS_CODE);
    }
}
