package com.shiguangping.beanvalidationdemo.common;

import lombok.Data;

@Data
public class RespResult<T> {

    private Integer code;

    private String msg;

    private T data;

    public RespResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
