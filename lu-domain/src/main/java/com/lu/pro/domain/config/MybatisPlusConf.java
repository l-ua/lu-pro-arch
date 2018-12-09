package com.lu.pro.domain.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/9
 */
@Configuration
public class MybatisPlusConf {
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MybatisObjectHandler();
    }

    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
