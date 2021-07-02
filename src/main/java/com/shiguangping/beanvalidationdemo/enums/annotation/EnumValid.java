package com.shiguangping.beanvalidationdemo.enums.annotation;

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

    Class<?> clazz();

    Class[] groups() default {};

    Class[] payload() default {};
}
