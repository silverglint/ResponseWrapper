package com.sky.responsewrapper.result;

import lombok.Data;

/**
 * Created by sk on 2022/1/12
 */
@Data
public class ResultInfo {

    private String code;
    private Object data;
    private String message;

    private ResultInfo(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ResultInfo success(String code, Object data, String message) {
        return new ResultInfo(code, data, message);
    }

    public static ResultInfo fail(String code, Object data, String message) {
        return new ResultInfo(code, data, message);
    }

    public static ResultInfo fail(String code, String message) {
        return new ResultInfo(code, null, message);
    }
}
