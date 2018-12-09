package com.lu.pro.domain.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/9
 */
public class MybatisObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createDate", new Date(), metaObject);
        setFieldValByName("createBy", "system", metaObject);
        setFieldValByName("createById", "system_id", metaObject);
        setFieldValByName("updateDate", new Date(), metaObject);
        setFieldValByName("updateBy", "system", metaObject);
        setFieldValByName("updateById","system_id", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateDate", new Date(), metaObject);
        setFieldValByName("updateBy", "system", metaObject);
        setFieldValByName("updateById","system_id", metaObject);
    }
}
