package com.shiguangping.beanvalidationdemo.validator;

import cn.hutool.core.util.StrUtil;
import com.shiguangping.beanvalidationdemo.annotation.DateFormatValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.UnexpectedTypeException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liyan
 */
public class DateFormatValidator implements ConstraintValidator<DateFormatValid, String> {
    @Override
    public void initialize(DateFormatValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StrUtil.isEmpty(value)) {
            return true;
        }
        String pattern = "^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(value);
        return m.matches();
    }
}
