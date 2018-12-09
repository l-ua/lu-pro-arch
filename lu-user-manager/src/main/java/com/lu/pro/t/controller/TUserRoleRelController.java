package com.lu.pro.t.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lu.pro.domain.controller.BaseController;
import com.lu.pro.t.entity.TUserRoleRel;
import com.lu.pro.t.service.impl.TUserRoleRelServiceImpl;
import io.swagger.annotations.Api;

/**
* <p>
    * 用户角色表 前端控制器
    * </p>
*
* @author 10758
* @since 2018-12-09
*/

@RestController
@RequestMapping("/t/t-user-role-rel")
@Api(value = "TUserRoleRelController",description = "用户角色表")
public class TUserRoleRelController extends BaseController<TUserRoleRelServiceImpl,TUserRoleRel> {

}

