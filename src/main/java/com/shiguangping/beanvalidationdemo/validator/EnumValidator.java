package com.shiguangping.beanvalidationdemo.validator;

import cn.hutool.core.util.ObjectUtil;
import com.shiguangping.beanvalidationdemo.annotation.EnumValid;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * @author liyan
 */
@Slf4j
public class EnumValidator implements ConstraintValidator<EnumValid, Integer> {

    private Class<Enum> clazz;

    @SneakyThrows
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // 允许为null
        if (ObjectUtil.isNull(value)) {
            return true;
        }
        Enum[] enums = clazz.getEnumConstants();
        Method getCode = clazz.getMethod("getCode");
        for (Enum anEnum : enums) {
            Integer code = (Integer) getCode.invoke(anEnum);
            if (value.equals(code)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void initialize(EnumValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        clazz = (Class<Enum>) constraintAnnotation.clazz();
    }
}
