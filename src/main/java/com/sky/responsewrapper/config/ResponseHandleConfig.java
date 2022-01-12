package com.sky.responsewrapper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sk on 2022/1/12
 */
@Data
@ConfigurationProperties(prefix = "response-handle")
public class ResponseHandleConfig {

    public Integer commonSuccessCode = 200;
    public Integer commonFailCode = -100;
    public String commonSuccessMessage = "success";
    public String commonFailMessage = "系统异常";
}
