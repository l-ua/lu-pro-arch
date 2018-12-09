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
 * 功能点
 * </p>
 *
 * @author 10758
 * @since 2018-12-09
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TFuncBaseDto", description="功能点")
public class TFuncBaseDto extends BaseDto {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "功能名称")
    private String funcName;
    @ApiModelProperty(value = "功能编码")
    private String funcCode;
    @ApiModelProperty(value = "读写权限，0：全有，1：写，2：读")
    private String funcType;
    @ApiModelProperty(value = "功能描述")
    private String funcDesc;
    @ApiModelProperty(value = "角色编码")
    private String tRoleCode;


}
