package com.sky.responsewrapper.handler;

import com.sky.responsewrapper.config.ResponseHandleConfig;
import com.sky.responsewrapper.exception.BaseException;
import com.sky.responsewrapper.result.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Pointcut("@within(com.sky.responsewrapper.annotation.ResponseHandle) || @annotation(com.sky.responsewrapper.annotation.ResponseHandle)")
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
            String eMessage = e.getMessage() == null ? e.toString() : e.getMessage();
            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            Matcher match = p.matcher(eMessage);
            log.error("系统运行时异常：[{}]", eMessage);
            return ResultInfo.fail(config.commonFailCode, match.find() ? eMessage : config.commonFailMessage);
        } catch (Throwable e) {
            e.printStackTrace();
            log.error("系统内部异常：[{}]", e.getMessage() == null ? e.toString() : e.getMessage());
            return ResultInfo.fail(config.commonFailCode, config.commonFailMessage);
        }
        return ResultInfo.success(config.commonSuccessCode, proceed, config.commonSuccessMessage);
    }

}
