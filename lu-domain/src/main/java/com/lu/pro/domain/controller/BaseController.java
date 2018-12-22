package com.lu.pro.domain.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlHelper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lu.pro.domain.dto.BaseDto;
import com.lu.pro.domain.entity.BaseEntity;
import com.lu.pro.domain.service.BaseService;
import com.lu.pro.domain.service.impl.BaseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.properties.Property;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/6
 */
@Api("所有controller基类 泛型S 代表service 泛型E代表entity")
public class BaseController<S extends BaseServiceImpl, E extends BaseEntity,ID extends Serializable> {

    @Autowired
    protected S service;

    protected Class<S> currentModelClass() {
        return ReflectionKit.getSuperClassGenericType(this.getClass(), 1);
    }

    @PostMapping(path = "/save", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "单个保存", notes = "单个保存")
    public R<E> save(@RequestBody E entity) {
        boolean res = service.save(entity);
        if (!res) {
            return R.failed("插入失败");
        }
        return R.ok(entity);
    }

    @SneakyThrows
    private <D extends BaseDto> E dto2Entity(D dto) {
        E e = (E) ReflectionKit.getSuperClassGenericType(this.getClass(), 2).newInstance();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, e);
        return e;
    }

    @PostMapping("/save-batch")
    @ApiOperation(value = "批量保存", notes = "批量保存")
    public <D extends BaseDto, T extends BaseEntity> R<List<E>> saveBatch(@RequestBody Collection<E> entityList) {
        service.saveBatch(entityList);
        return R.ok(new ArrayList<>(entityList));

    }

   /* private <D extends BaseDto, T extends BaseEntity> List<E> entity2Dto(List<E> entitys) {
        if (null == entitys || 0 == entitys.size()) {
            return null;
        }
        final List<E> dList = new ArrayList<>();
        entitys.stream().forEach(e -> dList.add(entity2Dto(e)));
        return dList;
    }*/

    private <D extends BaseDto, T extends BaseEntity> D entity2Dto(T e) {
        Object dto = new Object();
        D d = (D) dto;
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(e, d);
        return d;
    }

    @PostMapping("/save-or-update")
    @ApiOperation(value = "保存或者更新", notes = "保存或者更新")
    public R<Boolean> saveOrUpdate(@RequestBody E entity) {
        return R.ok(service.saveOrUpdate(entity));
    }

    @PostMapping("/save-or-update-batch")
    @ApiOperation(value = "批量保存或者批量更新", notes = "批量保存或者批量更新")
    public R<Boolean> saveOrUpdateBatch(@RequestBody Collection<E> entityList) {
        return R.ok(service.saveOrUpdateBatch(entityList));
    }

    @PostMapping("/remove-by-id")
    @ApiOperation(value = "通过主键删除", notes = "通过主键删除")
    public R<Boolean> removeById(@RequestBody ID id) {
        return R.ok(service.removeById(id));
    }

    @PostMapping("/remove-by-map")
    @ApiOperation(value = "通过map删除1", notes = "通过map删除")
    public R<Boolean> removeByMap(@RequestBody Map<String, Object> columnMap) {
        return R.ok(service.removeByMap(columnMap));
    }

    @PostMapping("/remove")
    @ApiOperation(value = "通过条件删除", notes = "通过条件删除")
    public R<Boolean> remove(@RequestBody Wrapper<E> wrapper) {
        return R.ok(service.remove(wrapper));
    }

    @PostMapping("/remove-by-ids")
    @ApiOperation(value = "通过主键集合删除", notes = "通过主键集合删除")
    public R<Boolean> removeByIds(@RequestBody Collection<ID> idList) {
        return R.ok(service.removeByIds(idList));
    }

    @PostMapping("/update-by-id")
    @ApiOperation(value = "通过主键更新", notes = "通过主键更新")
    public R<Boolean> updateById(@RequestBody E entity) {
        return R.ok(service.updateById(entity));
    }

    @PostMapping("/update")
    @ApiOperation(value = "通过条件更新", notes = "通过条件更新，第一个参数：更新后的实体，第二个参数：更新条件")
    public R<Boolean> update(E entity, Wrapper<E> updateWrapper) {
        return R.ok(service.update(entity, updateWrapper));
    }

    @PostMapping("/update-by-ids")
    @ApiOperation(value = "通过主键集合更新", notes = "通过主键集合更新")
    public R<Boolean> updateBatchById(@RequestBody Collection<E> entityList) {
        return R.ok(service.updateBatchById(entityList));
    }

    @GetMapping(value = "/get-by-id/{id}" )
    @ApiOperation(value = "通过主键获取记录", notes = "通过主键获取记录")
    public R<E> getById(@PathVariable ID id) {
        return R.ok((E) service.getById(id));
    }

    @PostMapping("/get-by-ids")
    @ApiOperation(value = "通过主键集合获取记录", notes = "通过主键集合获取记录")
    public R<Collection<E>> listByIds(@RequestBody Collection<ID> idList) {
        return R.ok(service.listByIds(idList));
    }

    @PostMapping("/get-by-map")
    @ApiOperation(value = "通过map获取记录", notes = "通过map获取记录")
    public R<Collection<E>> listByMap(@RequestBody Map<String, Object> columnMap) {
        return R.ok(service.listByMap(columnMap));
    }

    @PostMapping("/get-one")
    @ApiOperation(value = "通过条件获取唯一一条记录", notes = "通过条件获取唯一一条记录")
    public R<E> getOne(@RequestBody Wrapper<E> queryWrapper) {
        return R.ok((E) service.getOne(queryWrapper));
    }

    @PostMapping("/count")
    @ApiOperation(value = "根据条件进行数据量统计", notes = "根据条件进行数据量统计")
    public R<Integer> count(@RequestBody Wrapper<E> queryWrapper) {
        return R.ok(service.count(queryWrapper));
    }

    @PostMapping("/list")
    @ApiOperation(value = "根据条件查询", notes = "根据条件查询")
    public R<List<E>> list(@RequestBody Wrapper<E> queryWrapper) {
        return R.ok(service.list(queryWrapper));
    }

    @PostMapping("/page")
    @ApiOperation(value = "根据条件分页", notes = "根据条件分页")
    public R<IPage<E>> page(IPage<E> page, Wrapper<E> queryWrapper) {
        return R.ok(service.page(page, queryWrapper));
    }

}
