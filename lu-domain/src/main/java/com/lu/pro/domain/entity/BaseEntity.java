package com.lu.pro.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/6
 */
@Data
@Accessors(chain = true)
@ToString
@ApiModel("Entity的基类")
public class BaseEntity<T extends Model> extends Model<T> {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    @ApiModelProperty("唯一主键")
    protected String id;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    protected Date createDate;

    @ApiModelProperty("创建人")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    protected String createBy;

    @ApiModelProperty("创建人id")
    @TableField(value = "create_by_id", fill = FieldFill.INSERT)
    protected String createById;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    protected Date updateDate;

    @ApiModelProperty("更新人")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    protected String updateBy;

    @ApiModelProperty("更新人id")
    @TableField(value = "update_by_id", fill = FieldFill.INSERT_UPDATE)
    protected String updateById;

    @ApiModelProperty("是否删除0:没有删除，1：删除")
    @TableLogic(value = "is_delete")
    protected String isDelete;

    @ApiModelProperty("版本号")
    @Version
    protected Integer version;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
