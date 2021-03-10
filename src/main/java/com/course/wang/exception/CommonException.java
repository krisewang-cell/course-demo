package com.course.wang.exception;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.course.wang.exception.core.ErrorBuildResult;

/**
 * @apiNote 自定义普通异常
 * @author Wangjunlei
 * @date 2021/3/10 7:05 下午
 */
public class CommonException extends RuntimeException {
    private final ErrorBuildResult errorBuildResult;

    public CommonException(ErrorBuildResult errorBuildResult) {
        super(errorBuildResult.getErrorMessage());
        this.errorBuildResult = errorBuildResult;
    }

    public ErrorBuildResult getErrorBuildResult() {
        return this.errorBuildResult;
    }

}
