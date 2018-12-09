package com.lu.pro.t.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.lu.pro.t.dto.base.TFuncBaseDto;

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
@ApiModel(value="TFunc", description="功能点")
public class TFuncDto extends TFuncBaseDto{

}
