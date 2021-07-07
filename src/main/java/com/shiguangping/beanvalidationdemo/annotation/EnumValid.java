package com.shiguangping.beanvalidationdemo.annotation;

import com.shiguangping.beanvalidationdemo.validator.EnumValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验枚举值是否在参数范围内
 * 允许值为null
 *
 * @author liyan
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumValid {

    String message() default "";

    /**
     * 要校验的枚举类
     */
    Class<?> clazz();

    Class[] groups() default {};

    Class[] payload() default {};
}
