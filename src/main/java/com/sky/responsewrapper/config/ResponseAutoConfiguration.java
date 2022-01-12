package com.sky.responsewrapper.config;

import com.sky.responsewrapper.handler.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sk on 2022/1/12
 */
@Configuration
@EnableConfigurationProperties({ResponseHandleConfig.class})
@ComponentScan(value = "com.sky.responsewrapper.handler")
public class ResponseAutoConfiguration {
    @Autowired
    ResponseHandleConfig config;

    @Bean
    public ResponseHandler responseHandler() {
        return new ResponseHandler(config);
    }
}
