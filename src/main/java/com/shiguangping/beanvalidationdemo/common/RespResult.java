package com.shiguangping.beanvalidationdemo.common;

import lombok.Data;

@Data
public class RespResult<T> {

    private Integer code;

    private String msg;

    private T data;

    private RespResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private RespResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RespResult build(Integer code, String msg) {
        return new RespResult(code, msg);
    }

    public static <T> RespResult build(Integer code, String msg, T data) {
        return new RespResult(code, msg, data);
    }

}
