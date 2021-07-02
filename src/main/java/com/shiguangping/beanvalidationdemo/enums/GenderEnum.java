package com.shiguangping.beanvalidationdemo.enums;

/**
 * 性别枚举
 *
 * @author liyan
 */
public enum GenderEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    private Integer code;
    private String name;

    GenderEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
