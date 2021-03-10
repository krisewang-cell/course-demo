package com.course.wang.exception.core;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 * @author Wangjunlei
 * @date 2021/3/10 7:15 下午
 */
@Component
public class ErrorConfigProvider {

    public HashMap<Integer, String> getErrorMapping() {
        return ErrorConstants.ERROR_MAPPING;
    }
}
