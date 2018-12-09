package com.lu.pro.t.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lu.pro.domain.controller.BaseController;
import com.lu.pro.t.entity.TUser;
import com.lu.pro.t.service.impl.TUserServiceImpl;
import io.swagger.annotations.Api;

/**
* <p>
    * 用户管理系统-用户信息表 前端控制器
    * </p>
*
* @author 10758
* @since 2018-12-09
*/

@RestController
@RequestMapping("/t/t-user")
@Api(value = "TUserController",description = "用户管理系统-用户信息表")
public class TUserController extends BaseController<TUserServiceImpl,TUser> {

}

