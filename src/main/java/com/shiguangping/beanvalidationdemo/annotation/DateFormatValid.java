package com.shiguangping.beanvalidationdemo.annotation;

import com.shiguangping.beanvalidationdemo.validator.DateFormatValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 校验String类型日期格式，yyyy-MM-dd
 * @author 日期格式校验
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
public @interface DateFormatValid {

    String message() default "";

    Class[] groups() default {};

    Class[] payload() default {};
}
