package com.lu.pro.domain.annotation;

import java.lang.annotation.*;

/**
 * @autor 10758
 * @system lu-pro-arch 系统日志
 * @Time 2018/12/15
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";

}
