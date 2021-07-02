package com.shiguangping.beanvalidationdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer gender;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 电话号码
     */
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

}
