package com.course.wang.exception.core;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.course.wang.exception.CommonException;

import lombok.Data;

/**
 * 异常基类builder
 * @author Wangjunlei
 * @date 2021/3/10 7:17 下午
 */
@Data
@Component
public class ExceptionBuilder {
    private Boolean errorPublic;
    private Integer systemCode;
    private Integer moduleCode;
    private final ErrorConfigProvider errorConfigurationProvider;


    public ExceptionBuilder(ErrorConfigProvider errorConfigurationProvider) {
        this.errorConfigurationProvider = errorConfigurationProvider;
    }

    public CommonException create(Integer errCode) {
        return this.buildException(errCode, "", new HashMap());
    }

    public CommonException create(Integer errCode, HashMap<String, String> extra) {
        return this.buildException(errCode, "", extra);
    }

    public CommonException create(Integer errCode, String message) {
        return this.buildException(errCode, message, new HashMap());
    }

    public CommonException create(Integer errCode, String message, HashMap<String, String> extra) {
        return this.buildException(errCode, message, extra);
    }

    private CommonException buildException(Integer errCode, String message, HashMap<String, String> extra) {
        try {
            HashMap<Integer, String> errorMapping = this.errorConfigurationProvider.getErrorMapping();
            if (!errorMapping.containsKey(errCode)) {
                throw new RuntimeException("无法生成CommonException实例[原因:错误码不存在]");
            } else {
                if (StringUtils.isBlank(message)) {
                    message = errorMapping.get(errCode);
                }

                ErrorBuildResult errResult = new ErrorBuildResult();
                errResult.setErrorCode(errCode);
                errResult.setErrorMessage(message);
                errResult.setErrorPublic(this.errorPublic);
                errResult.setModuleCode(this.moduleCode);
                errResult.setSystemCode(this.systemCode);
                CommonException instance = new CommonException(errResult);
                Logger logger = LoggerFactory.getLogger(ExceptionBuilder.class);

                logger.error("ErrorCode:{}, ErrorMessage:{};Detail:{}", errCode, message, instance.getMessage());
                return instance;
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("无法生成CommonException实例[原因:实例生成异常]");
        }
    }

}