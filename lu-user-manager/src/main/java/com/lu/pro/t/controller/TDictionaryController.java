package com.lu.pro.t.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lu.pro.domain.controller.BaseController;
import com.lu.pro.t.entity.TDictionary;
import com.lu.pro.t.service.impl.TDictionaryServiceImpl;
import io.swagger.annotations.Api;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author 10758
* @since 2018-12-09
*/

@RestController
@RequestMapping("/t/t-dictionary")
@Api(value = "TDictionaryController",description = "")
public class TDictionaryController extends BaseController<TDictionaryServiceImpl,TDictionary> {

}

