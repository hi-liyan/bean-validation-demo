package com.shiguangping.beanvalidationdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liyan
 */
@Slf4j
@SpringBootApplication
public class BeanValidationDemoApplication {

    public static void main(String[] args) {
        log.info("项目开始启动...");
        SpringApplication.run(BeanValidationDemoApplication.class, args);
        log.info("项目启动完成");
    }

}
