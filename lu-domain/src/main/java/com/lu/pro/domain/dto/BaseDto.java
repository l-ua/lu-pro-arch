package com.lu.pro.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/6
 */
@Data
@Accessors(chain = true)
@ToString
@ApiModel("dto的基类")
public class BaseDto {
    @ApiModelProperty("唯一主键")
    protected String id;

    @ApiModelProperty("创建时间")
    protected Date createDate;

    @ApiModelProperty("创建人")
    protected String createBy;

    @ApiModelProperty("创建人id")
    protected String createById;

    @ApiModelProperty("更新时间")
    protected Date updateDate;

    @ApiModelProperty("更新人")
    protected String updateBy;

    @ApiModelProperty("更新人id")
    protected String updateById;

    @ApiModelProperty("是否删除0:没有删除，1：删除")
    protected String isDelete;

    @ApiModelProperty("版本号")
    protected Integer version;
}
