package com.lu.pro.domain.annotation.aop;

import com.lu.pro.domain.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/15
 */
@Aspect
@Slf4j
@Configuration
@Order(-1)
public class SysLogAop {
    private static Long costTime;

    @Pointcut(" @target(org.springframework.stereotype.Controller) || "
            + " @target(org.springframework.web.bind.annotation.RestController) ")
    public void controllerPointcut() {
    }

    @Pointcut(" @annotation(org.springframework.web.bind.annotation.RequestMapping) "
            + " || @annotation(org.springframework.web.bind.annotation.PostMapping) "
            + " || @annotation(org.springframework.web.bind.annotation.GetMapping) ")
    public void methodPointcut() {
    }

    private void printStartTime() {
        costTime = System.currentTimeMillis();
    }


    @Before("controllerPointcut() && methodPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        printStartTime();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LocalDate localDate= LocalDate.now();

        //记录请求路径url method
        log.info("ThreadName={},StartTime={},Method={},Url={}", Thread.currentThread().getName(), localDate,
                request.getMethod(), request.getRequestURL());
        //记录访问者ip
        StringBuffer sb = new StringBuffer();
        //log.info("ip={}", request.getRemoteAddr());
        Object[] args = joinPoint.getArgs();
        // 记录请求参数
        log.info("Parameters={}", Stream.of(args).
                map(o -> o.toString())
                .collect(Collectors.joining(",")));


    }


    @After("controllerPointcut() && methodPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Long cost = System.currentTimeMillis() - costTime;
        //记录请求路径url method
        log.info("ThreadName={},CostTime={}ms,Method={},Url={}", Thread.currentThread().getName(),
                cost,
                request.getMethod(), request.getRequestURL());
        if (cost > 2000) {
            log.info("ThreadName={},Url={} 耗时超过 2秒，请对方法进行优化", Thread.currentThread().getName(),
                    request.getRequestURL());
        }
    }


}
