package com.course.wang.exception.core;

import java.util.HashMap;

/**
 * @apiNote 定义常量错误码
 * @author Wangjunlei
 * @date 2021/3/10 7:10 下午
 */
public class ErrorConstants {

    public static final Integer SUCCESS_CODE = 0;

    public static HashMap<Integer, String> ERROR_MAPPING = new HashMap<>();
    static {
        ERROR_MAPPING.put(SUCCESS_CODE, "SUCCESS");

    }
}
