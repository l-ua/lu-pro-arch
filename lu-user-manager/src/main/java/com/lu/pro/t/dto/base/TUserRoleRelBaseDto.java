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
 * 用户角色表
 * </p>
 *
 * @author 10758
 * @since 2018-12-09
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TUserRoleRelBaseDto", description="用户角色表")
public class TUserRoleRelBaseDto extends BaseDto {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "角色编码")
    private String tRoleCode;
    @ApiModelProperty(value = "用户id")
    private String tUserId;


}
