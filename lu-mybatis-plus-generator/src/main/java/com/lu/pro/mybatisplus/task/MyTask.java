package com.lu.pro.mybatisplus.task;

import com.lu.pro.mybatisplus.service.PlusGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/6
 */
@Service
@Slf4j
public class MyTask implements ApplicationRunner {
    @Autowired
    private PlusGenerator generator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("===================开始自动生成代码===============");
        generator.generator();
        log.info("===================自动生成代码结束===============");
        log.info("===================服务停止===============");
        System.exit(0);
    }
}
