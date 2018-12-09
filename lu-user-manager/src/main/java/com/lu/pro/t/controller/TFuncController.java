package com.lu.pro.t.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lu.pro.domain.controller.BaseController;
import com.lu.pro.t.entity.TFunc;
import com.lu.pro.t.service.impl.TFuncServiceImpl;
import io.swagger.annotations.Api;

/**
* <p>
    * 功能点 前端控制器
    * </p>
*
* @author 10758
* @since 2018-12-09
*/

@RestController
@RequestMapping("/t/t-func")
@Api(value = "TFuncController",description = "功能点")
public class TFuncController extends BaseController<TFuncServiceImpl,TFunc> {

}

