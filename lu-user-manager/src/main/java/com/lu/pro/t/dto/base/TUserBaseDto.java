package com.lu.pro.t.dto.base;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.lu.pro.domain.dto.BaseDto;


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
@ApiModel(value="TUserBaseDto", description="用户管理系统-用户信息表")
public class TUserBaseDto extends BaseDto {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "中文名称")
    private String cnName;
    @ApiModelProperty(value = "英文名称")
    private String enName;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "微信open_id")
    private String openId;
    @ApiModelProperty(value = "性别 01：男，02：女")
    private String sex;
    @ApiModelProperty(value = "出生年月日")
    private Date birthday;
    @ApiModelProperty(value = "年级")
    private Integer age;
    @ApiModelProperty(value = "电话")
    private String tel;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "职业")
    private String occupation;
    @ApiModelProperty(value = "身高")
    private Double height;
    @ApiModelProperty(value = "体重(KG)")
    private Double weight;
    @ApiModelProperty(value = "身份证")
    private String idCard;


}
