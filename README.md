# ResponseWrapper
返回值与异常处理

需要包装返回值的controller层添加 @ResponseHandle 注解
自定义异常继承 BaseException 类
yml配置通用返回码
response-handle:
    common-fail-code: -5
    common-fail-message: 系统异常
    common-success-code: 300
    common-success-message: success
