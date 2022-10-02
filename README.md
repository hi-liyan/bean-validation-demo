# bean-validation-demo

## 介绍
Bean Validation 快速开始

## 参数校验

参数校验是非常常见的一种应用场景，如对前端请求参数的校验，如果传入的参数不合法，则返回相应的错误信息。

如何对参数进行校验呢？可以通过代码做校验，比如使用if语句写判断逻辑校验参数，但这种方式显然很麻烦，也不好维护。

所以，Java提出了参数校验的标准，`JSR 303: Bean Validation`。

<br>

## 什么是JSR303

JSR是`Java Specification Requests`的缩写，即 Java 规范请求，它是对 Java 平台的提议和最终规范的实际描述。任何时候都有许多 JSR 正在经历审查和批准过程。

而`JSR303`提出了`Bean Validation`，即Bean 验证。通俗地说，JSR303 指的是Java制定的一套参数校验标准。大家按照这套标准去做具体的参数检验的实现逻辑，官方参考实现是`hibernate-validator`。

后续还提出了`JSR 349: Bean Validation 1.1`，`JSR 380: Bean Validation 2.0`。

<br>

**参考**

- [JSR概述](https://jcp.org/en/jsr/overview)

<br>

## 添加依赖

```xml
<!-- Bean Validation 接口 -->
<dependency>
  <groupId>javax.validation</groupId>
  <artifactId>validation-api</artifactId>
</dependency>
<!-- hibernate 实现 -->
<dependency>
  <groupId>org.hibernate.validator</groupId>
  <artifactId>hibernate-validator</artifactId>
</dependency>
```

Spring Boot项目也可直接引用官方封装好的Starter。

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

<br>

## 常用注解

| 注解         | 可使用类型                                                   | 说明                                                     |
| ------------ | ------------------------------------------------------------ | -------------------------------------------------------- |
| @Null        | any type                                                     | 被注释的元素必须为 null                                  |
| @NotNull     | any type                                                     | 被注释的元素必须不为 null                                |
| @AssertTrue  | boolean and Boolean                                          | 被注释的元素必须为 true                                  |
| @AssertFalse | boolean and Boolean                                          | 被注释的元素必须为 false                                 |
| @Min         | BigDecimal<br/>BigInteger<br/>byte, short, int, long, and their respective wrappers | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值 |
| @Max         | BigDecimal<br/>BigInteger<br/>byte, short, int, long, and their respective wrappers | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值 |
| @DecimalMin  | BigDecimal<br/>BigInteger<br/>CharSequence<br/>byte, short, int, long, and their respective wrappers | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值 |
| @DecimalMax  | BigDecimal<br/>BigInteger<br/>CharSequence<br/>byte, short, int, long, and their respective wrappers | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值 |
| @Size        | CharSequence (length of character sequence is evaluated)<br/>Collection (collection size is evaluated)<br/>Map (map size is evaluated)<br/>Array (array length is evaluated) | 被注释的元素的大小必须在指定的范围内                     |
| @Digits      | BigDecimal<br/>BigInteger<br/>CharSequence<br/>byte, short, int, long, and their respective wrapper types | 被注释的元素必须是一个数字，其值必须在可接受的范围内     |
| @Past        | java.util.Date<br/>java.util.Calendar<br/>java.time.Instant<br/>java.time.LocalDate<br/>java.time.LocalDateTime<br/>java.time.LocalTime<br/>java.time.MonthDay<br/>java.time.OffsetDateTime<br/>java.time.OffsetTime<br/>java.time.Year<br/>java.time.YearMonth<br/>java.time.ZonedDateTime<br/>java.time.chrono.HijrahDate<br/>java.time.chrono.JapaneseDate<br/>java.time.chrono.MinguoDate<br/>java.time.chrono.ThaiBuddhistDate | 被注释的元素必须是一个过去的日期                         |
| @Future      | java.util.Date<br/>java.util.Calendar<br/>java.time.Instant<br/>java.time.LocalDate<br/>java.time.LocalDateTime<br/>java.time.LocalTime<br/>java.time.MonthDay<br/>java.time.OffsetDateTime<br/>java.time.OffsetTime<br/>java.time.Year<br/>java.time.YearMonth<br/>java.time.ZonedDateTime<br/>java.time.chrono.HijrahDate<br/>java.time.chrono.JapaneseDate<br/>java.time.chrono.MinguoDate<br/>java.time.chrono.ThaiBuddhistDate | 被注释的元素必须是一个将来的日期                         |
| @Pattern     | CharSequence                                                 | 被注释的元素必须符合指定的正则表达式                     |
| @Email       | CharSequence                                                 | 被注释的元素必须是电子邮箱地址                           |
| @Length      | String                                                       | 被注释的字符串的大小必须在指定的范围内                   |
| @NotEmpty    | CharSequence (length of character sequence is evaluated)<br/>Collection (collection size is evaluated)<br/>Map (map size is evaluated)<br/>Array (array length is evaluated) | 被注释的元素的必须不能为 null 或者 empty                 |
| @Range       | 数值类型或者字符串形式的数值                                 | 被注释的元素必须在合适的范围内                           |
| @NotBlank    | CharSequence                                                 | 被注释的元素必须不为 null ，并且至少包含一个非空格的字符 |

以上是Bean Validation的常用注解，使用时要注意注解可以被使用的参数类型。

其中，`CharSequence`是字符序列，比如String。

没有特殊说明的注解，一般都是允许参数为`null`的，具体使用时可以参考注解的注释，都有说明。

还有两个用于开启参数校验的注解：

| 注解       | 作用类型                   | 说明                                                         |
| ---------- | -------------------------- | ------------------------------------------------------------ |
| @Valid     | 属性、方法参数、方法返回值 | 在验证属性、方法参数或方法返回类型时，将验证对象及其属性上定义的约束 |
| @Validated |                            | JSR-303的javax.validation.Valid的变体，支持验证组规范。旨在方便地使用Spring的JSR-303支持，但不特定于JSR-303。 |



<br>

## 统一异常处理

使用参数校验有这么一种应用场景，在校验请求参数时，当某个请求参数不合法时，会向前端返回相应的错误信息，如下图：

<img src="https://images.shiguangping.com/imgs/20210702232829.png" alt="image-20210702232828955" style="width:80%;" />

这种方式，是通过Spring MVC的两个注解（`@ControllerAdvice` + `@ExceptionHandler`）实现的统一异常处理。

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, Object> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
    ObjectError error = e.getBindingResult().getAllErrors().get(0);
    return ExceResult.build(RespStatusEnum.getCodeByName(error.getCode()), error.getDefaultMessage());
  }
}
```

<br>

注解：

- @ControllerAdvice 可能和@Controller一样，返回ModelAndView，没做过验证。使用@ControllerAdvice如果想返回json，类或者方法上需要加@ResponseBody。
- @ResrControllerAdvice 返回json。
- @ExceptionHander 声明具体要处理异常的类型，它会最先处理粒度最小的异常。

<br>

优缺点：

- 优点：将Controller层和数据校验的异常进行统一处理，提高开发效率；
- 缺点：只能处理Controller层未捕获的异常，对于拦截器(Interceptor)和Spring 框架中发生的异常无法处理。

<br>

**可以到[Gitee仓库](https://gitee.com/ENNRIAAA/bean-validation-demo.git)查看具体示例代码。**

<br>

## 自定义校验注解

我们可以根据自己的需求来自定义参数校验注解，例如我在示例代码中实现的，校验请求参数中传入的值是否在枚举范围内。

比如User中的性别属性gender，它有两个值：1男、2女，我们一般会定义一个枚举类型：GenderEnum（1男、2女）。当前端传的gender值为3时，说明请求参数是不合法的，这时应该返回一个错误信息给前端。这种场景就可以自定义一个校验注解，专门用来校验是枚举值的参数。

<br>

具体实现方式：

1. 定义注解。

   ```java
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
   // 指定约束校验器
   @Constraint(validatedBy = EnumValidator.class)
   public @interface EnumValid {
   		
     	/**
     	 * 异常信息
     	 */
       String message() default "";
   		/**
        * 要校验的枚举类
        */
       Class<?> clazz();
   
       Class[] groups() default {};
   
       Class[] payload() default {};
   }
   ```

2. 定义约束校验器。(实现`ConstraintValidator`接口)

   ```java
   package com.shiguangping.beanvalidationdemo.enums.annotation;
   
   import cn.hutool.core.util.ObjectUtil;
   import lombok.SneakyThrows;
   import lombok.extern.slf4j.Slf4j;
   
   import javax.validation.ConstraintValidator;
   import javax.validation.ConstraintValidatorContext;
   import java.lang.reflect.Method;
   
   /**
    * @author liyan
    */
   public class EnumValidator implements ConstraintValidator<EnumValid, Integer> { // 接口泛型中第一个是对应的注解，第二个是被注解的参数类型
   
       private Class<Enum> clazz;
   
       @SneakyThrows
       @Override
       public boolean isValid(Integer value, ConstraintValidatorContext context) {
           // 参数允许为null
           if (ObjectUtil.isNull(value)) {
               return true;
           }
         	// 获取枚举中所有的枚举常量
           Enum[] enums = clazz.getEnumConstants();
         	// 得到getCode()方法的Method对象
           Method getCode = clazz.getMethod("getCode");
         	// 遍历枚举中所有的枚举常量
           for (Enum anEnum : enums) {
             	// 通过getCode()方法的Method对象调用该方法，传入枚举枚举常量，得到枚举的code值
               Integer code = (Integer) getCode.invoke(anEnum);
             	// 如果校验的参数的值和当前遍历的枚举常量值相等，返回true
               if (value.equals(code)) {
                   return true;
               }
           }
         	// 如果校验的参数的值在枚举中不存在，返回false
           return false;
       }
   
       @Override
       public void initialize(EnumValid constraintAnnotation) {
           ConstraintValidator.super.initialize(constraintAnnotation);
         	// 获取注解的clazz的属性值，也就是指定的枚举的Class对象
           clazz = (Class<Enum>) constraintAnnotation.clazz();
       }
   }
   ```

3. 参数添加自定义注解。

   ```java
   /**
    * 性别 1男 2女
    */
   @EnumValid(clazz = GenderEnum.class, message = "gender: 超出枚举范围")
   private Integer gender;
   ```

4. 测试。

   <img src="https://upyun1.surcode.cn/imgs/20210703001155.png" />





