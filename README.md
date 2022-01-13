# ResponseWrapper
返回值与异常处理

需要包装返回值的controller层添加 @ResponseHandle 注解  
自定义异常继承 BaseException 类，业务问题直接抛出 exception 即可  
yml配置通用返回码及信息  
```
response-handle:  
  common-fail-code: -100  
  common-fail-message: 系统异常  
  common-success-code: 200  
  common-success-message: success
```
```java
public class TestException extends BaseException {

    public static final TestException TEST_EXCEPTION_1 = new TestException("101", null, "测试错误1");
    public static final TestException TEST_EXCEPTION_2 = new TestException("102", null, "测试错误2");

    public TestException(String code, Object data, String message1) {
        super(code, data, message1);
    }
}
```
```
    @GetMapping("test1")
    public Object test1(boolean flag) {
        if(flag){
            throw TestException.TEST_EXCEPTION_1;
        }else{
            return 1;
        }
    }
```
```json
{"code":"101","data":null,"message":"测试错误1"}
```
```json
{"code":"200","data":1,"message":"success"}
```

