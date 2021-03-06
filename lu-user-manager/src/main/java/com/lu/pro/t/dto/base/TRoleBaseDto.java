package com.lu.pro.t.dto.base;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.lu.pro.domain.dto.BaseDto;


/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 10758
 * @since 2018-12-09
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TRoleBaseDto", description="角色表")
public class TRoleBaseDto extends BaseDto {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "父节点id")
    private String parentId;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;
    @ApiModelProperty(value = "角色code")
    private String roleCode;


}
