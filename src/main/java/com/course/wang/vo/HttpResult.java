package com.course.wang.vo;

import lombok.Data;

/**
 * @author Wangjunlei
 * @date 2021/3/10 2:42 下午
 */
@Data
public class HttpResult<T> {
    private Integer code;
    private String message;
    private T data;
}
