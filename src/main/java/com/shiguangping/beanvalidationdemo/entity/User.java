package com.shiguangping.beanvalidationdemo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shiguangping.beanvalidationdemo.enums.GenderEnum;
import com.shiguangping.beanvalidationdemo.enums.annotation.EnumValid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    /**
     * id
     */
    @NotNull(message = "id: 不能为空")
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    @DecimalMin(value = "0", message = "age: 不得小于0")
    private Integer age;

    /**
     * 性别 1男 2女
     */
    @EnumValid(clazz = GenderEnum.class, message = "gender: 超出枚举范围")
    private Integer gender;

    /**
     * 出生日期
     */
    @Past(message = "birthday: 出生日期不能大于今天")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 电话号码
     */
    @Pattern(regexp = "^((13[0-9])|(14[5-9])|(15([0-3]|[5-9]))|(16[6-7])|(17[1-8])|(18[0-9])|(19[1|3])|(19[5|6])|(19[8|9]))\\d{8}$",
            message = "mobile: 手机号格式不正确")
    private String mobile;

    /**
     * 余额
     */
    @DecimalMin(value = "0", message = "balance: 不得小于0")
    @DecimalMax(value = "99999", message = "balance: 不得大于99999")
    private BigDecimal balance;

    /**
     * 擅长的编程语言
     */
    @Valid
    @NotEmpty(message = "languages: 不能为空")
    private List<Language> languages;

    /**
     * 体重
     */
    @Null(message = "weight: 必须为空")
    private String weight;

    @AssertTrue(message = "bool1: 必须为true")
    private boolean bool1;

    /**
     * 爱好
     */
    @NotEmpty(message = "hobbies: 不允许为空")
    @Size(min = 2, max = 5, message = "hobbies: 元素个数2~5")
    private List<String> hobbies;

    @Email(message = "email: 邮箱格式不正确")
    private String email;

    @NotBlank(message = "addr: 地址不能为空")
    private String addr;

}
