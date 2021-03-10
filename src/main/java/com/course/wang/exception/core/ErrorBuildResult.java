package com.course.wang.exception.core;

import lombok.Data;

/**
 * @apiNote runtime异常捕获
 * @author Wangjunlei
 * @date 2021/3/10 7:08 下午
 */
@Data
public class ErrorBuildResult {
    private Boolean errorPublic;
    private Integer systemCode;
    private Integer moduleCode;
    private Integer errorCode;
    private String errorMessage;
}
