package com.sky.responsewrapper.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by sk on 2022/1/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseException extends RuntimeException {

    private String code;
    private Object data;
    private String message;

    public BaseException(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
