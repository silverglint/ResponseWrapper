package com.sky.responsewrapper.result;

import lombok.Data;

/**
 * Created by sk on 2022/1/12
 */
@Data
public class ResultInfo {

    private Integer code;
    private Object data;
    private String message;

    private ResultInfo(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ResultInfo success(Integer code, Object data, String message) {
        return new ResultInfo(code, data, message);
    }

    public static ResultInfo fail(Integer code, Object data, String message) {
        return new ResultInfo(code, data, message);
    }

    public static ResultInfo fail(Integer code, String message) {
        return new ResultInfo(code, null, message);
    }
}
