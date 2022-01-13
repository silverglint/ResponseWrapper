package com.sky.responsewrapper.exception;

/**
 * Created by sk on 2022/1/12
 */
public class TestException extends BaseException {

    public static final TestException TEST_EXCEPTION_1 = new TestException("101", null, "测试错误1");
    public static final TestException TEST_EXCEPTION_2 = new TestException("102", null, "测试错误2");

    public TestException(String code, Object data, String message1) {
        super(code, data, message1);
    }
}
