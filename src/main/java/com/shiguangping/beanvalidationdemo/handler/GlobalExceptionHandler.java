package com.shiguangping.beanvalidationdemo.handler;

import com.shiguangping.beanvalidationdemo.enums.RespStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author liyan
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> exceptionHandler(Exception e) {
        e.printStackTrace();
        return ExceResult.build(500, "系统内部异常");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return ExceResult.build(RespStatusEnum.getCodeByName(error.getCode()), error.getDefaultMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return ExceResult.build(RespStatusEnum.REQUESTMETHOD.getCode(),RespStatusEnum.REQUESTMETHOD.getDesc());
    }

    static class ExceResult {
        public static Map<String, Object> build(Integer code, String msg) {
            Map<String, Object> map = new HashMap<>(16);
            map.put("code", code);
            map.put("msg", msg);
            return map;
        }
    }
}
