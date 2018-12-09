package ${cfg.packageName}.dto;

<#list table.importPackages as pkg>
import ${pkg};
</#list>

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import ${cfg.packageName}.dto.base.${entity}BaseDto;

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
@ApiModel(value="${entity}", description="${table.comment!}")
public class ${entity}Dto extends ${entity}BaseDto{

}
