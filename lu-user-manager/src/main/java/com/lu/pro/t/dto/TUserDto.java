package com.lu.pro.t.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.lu.pro.t.dto.base.TUserBaseDto;

/**
 * <p>
 * 用户管理系统-用户信息表
 * </p>
 *
 * @author 10758
 * @since 2018-12-09
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TUser", description="用户管理系统-用户信息表")
public class TUserDto extends TUserBaseDto{

}
