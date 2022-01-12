package com.sky.responsewrapper.handler;

import com.sky.responsewrapper.config.ResponseHandleConfig;
import com.sky.responsewrapper.exception.BaseException;
import com.sky.responsewrapper.result.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by sk on 2022/1/12
 */
@Aspect
@Slf4j
public class ResponseHandler {

    private final ResponseHandleConfig config;

    public ResponseHandler(ResponseHandleConfig config) {
        this.config = config;
    }

    @Pointcut("within(@com.sky.responsewrapper.annotation.ResponseHandle *)")
    private void pointcut() {
    }

    @Around("pointcut()")
    public Object before(ProceedingJoinPoint pjp) {
        Object proceed;
        try {
            proceed = pjp.proceed();
        } catch (BaseException e) {
            return ResultInfo.fail(e.getCode(), e.getData(), e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
            log.error("系统运行时异常：[{}]", e.getMessage());
            return ResultInfo.fail(config.commonFailCode, config.commonFailMessage);
        } catch (Throwable e) {
            e.printStackTrace();
            log.error("系统内部异常：[{}]", e.getMessage());
            return ResultInfo.fail(config.commonFailCode, config.commonFailMessage);
        }
        return ResultInfo.success(config.commonSuccessCode, proceed, config.commonSuccessMessage);
    }

}
