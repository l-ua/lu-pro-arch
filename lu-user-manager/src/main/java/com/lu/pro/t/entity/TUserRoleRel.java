package com.lu.pro.t.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lu.pro.t.entity.base.TUserRoleRelBaseEntity;

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
@TableName("t_user_role_rel")
@ApiModel(value="TUserRoleRel", description="用户角色表")
public class TUserRoleRel extends TUserRoleRelBaseEntity<TUserRoleRel> {

}
