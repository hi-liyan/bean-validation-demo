package com.shiguangping.beanvalidationdemo.enums;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;

/**
 * 响应状态枚举
 *
 * @author liyan
 */
@Slf4j
public enum RespStatusEnum {

    NOTNULL(2001, "NotNull", "参数不能为空"),
    NULL(2002, "Null", "参数必须为空"),
    ASSERTTRUE(2003, "AssertTrue", "参数必须为true"),
    ASSERTFALSE(2004, "AssertFalse", "参数必须为False"),
    MIN(2005, "Min", ""),
    MAX(2006, "Max", ""),
    DECIMALMIN(2005, "DecimalMin", ""),
    DECIMALMAX(2006, "DecimalMax", ""),
    SIZE(2007, "Size", "元素个数不在取值范围内"),
    PATTERN(2008, "Pattern", "格式不正确"),
    NOTEMPTY(2009, "NotEmpty", ""),
    ENUMVALID(2010,"EnumValid","");

    private Integer code;
    private String name;
    private String desc;

    RespStatusEnum(Integer code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Integer getCodeByName(String name) {
        Optional<RespStatusEnum> first = Arrays.stream(RespStatusEnum.values())
                .filter(i -> StrUtil.equals(i.getName(), name))
                .findFirst();
        return first.isPresent() ? first.get().getCode() : null;
    }
}
