package com.sky.responsewrapper.annotation;

import java.lang.annotation.*;

/**
 * Created by sk on 2022/1/12
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseHandle {
}
