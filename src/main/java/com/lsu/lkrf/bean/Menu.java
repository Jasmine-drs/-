package com.lsu.lkrf.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单表
 * @Date 2023-05-03 09:21:45
 * @author Jasmine-drs
 */
@Data
@TableName("menu")
@ApiModel(value="Menu对象", description="菜单表")
public class Menu implements Serializable {

    @NotNull(message="[索引]不能为空")
    @ApiModelProperty("索引")
    private Object id;

    @NotBlank(message="[菜单名称]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("菜单名称")
    private String name;

    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("页面地址")
    private String addr;

    @ApiModelProperty("更新者id")
    private Integer upId;

    @NotNull(message="[状态]不能为空")
    @ApiModelProperty("是否启用，0 停用，1 启用")
    private Integer state;

    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("")
    private Date updateTime;

}
