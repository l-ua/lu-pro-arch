package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lu.pro.domain.controller.BaseController;
import ${package.Entity}.${entity};
import ${package.ServiceImpl}.${table.serviceImplName};
import io.swagger.annotations.Api;

/**
* <p>
* ${table.comment!} 前端控制器
* </p>
*
* @author ${author}
* @since ${date}
*/

@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(value = "${table.controllerName}",description = "${table.comment!}")
public class ${table.controllerName} extends BaseController<${table.serviceImplName},${entity}> {

}

