package com.sky.responsewrapper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sk on 2022/1/12
 */
@Data
@ConfigurationProperties(prefix = "response-handle")
public class ResponseHandleConfig {

    public Integer commonSuccessCode;
    public Integer commonFailCode;
    public String commonSuccessMessage;
    public String commonFailMessage;
}
