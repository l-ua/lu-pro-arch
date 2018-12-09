package com.lu.pro.domain.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lu.pro.domain.service.BaseService;
import io.swagger.annotations.Api;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/6
 */
@Api("所有serviceimpl基类")
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService {
}
