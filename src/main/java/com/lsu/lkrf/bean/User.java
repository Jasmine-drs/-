package com.lsu.lkrf.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户管理，0为普通员工，1为程序操作员，2为管理员
 * @Date 2023-04-30 14:54:22
 * @author Jasmine-drs
 */
@Data
@TableName("user")
@ApiModel(value="User对象", description="用户管理，0为普通员工，1为程序操作员，2为管理员")
public class User implements Serializable {

    @NotNull(message="[索引]不能为空")
    @ApiModelProperty("索引")
    private Object id;

    @NotBlank(message="[账号]不能为空")
    @Size(max= 16,message="编码长度不能超过16")
    @ApiModelProperty("账号")
    private String code;

    @NotBlank(message="[姓名]不能为空")
    @Size(max= 16,message="编码长度不能超过16")
    @ApiModelProperty("姓名")
    private String name;

    @NotNull(message="[角色]不能为空")
    @ApiModelProperty("角色")
    private Integer role;

    @Size(max= 12,message="编码长度不能超过12")
    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("组织")
    private Integer org;

    @Size(max= 16,message="编码长度不能超过16")
    @ApiModelProperty("加密之后的密码")
    private String password;

    @Size(max= 18,message="编码长度不能超过18")
    @ApiModelProperty("身份证号")
    private String identity;

    @NotNull(message="[状态：0 停用，1 启用]不能为空")
    @ApiModelProperty("状态：0 停用，1 启用")
    private Integer state;

    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("")
    private Integer staff;

    @ApiModelProperty("注册时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}
