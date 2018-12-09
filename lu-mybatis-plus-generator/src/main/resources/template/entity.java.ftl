package ${package.Entity};

<#list table.importPackages as pkg>
import ${pkg};
</#list>

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import ${package.Entity}.base.${entity}BaseEntity;

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("${table.name}")
@ApiModel(value="${entity}", description="${table.comment!}")
public class ${entity} extends ${entity}BaseEntity<#if activeRecord><${entity}></#if> {

}
