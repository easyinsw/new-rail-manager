package com.yinsw.common.security.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;
import java.lang.annotation.*;

/**
 * 自定义feign注解
 * 添加basePackages路径
 * 
 * @author yinsw
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableYinswFeignClients
{
    String[] value() default {};

    String[] basePackages() default { "com.yinsw" };

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
