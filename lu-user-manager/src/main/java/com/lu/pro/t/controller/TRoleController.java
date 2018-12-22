package com.lu.pro.t.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lu.pro.domain.controller.BaseController;
import com.lu.pro.t.entity.TRole;
import com.lu.pro.t.service.impl.TRoleServiceImpl;
import io.swagger.annotations.Api;

/**
* <p>
    * 角色表 前端控制器
    * </p>
*
* @author 10758
* @since 2018-12-09
*/

@RestController
@RequestMapping("/t/t-role")
@Api(value = "TRoleController",description = "角色表")
public class TRoleController extends BaseController<TRoleServiceImpl,TRole,String> {

}

