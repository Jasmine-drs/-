package com.lsu.lkrf.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 
 * @Date 2023-05-07 10:48:36
 * @author Jasmine-drs
 */
@Data
@TableName("package")
@ApiModel(value="Package对象", description="")
public class Package implements Serializable {

    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Object id;

    @NotNull(message="[工种、流程]不能为空")
    @ApiModelProperty("工种、流程")
    private Integer product;

    @NotNull(message="[对应package表]不能为空")
    @ApiModelProperty("对应package表")
    private Integer pac;

    @ApiModelProperty("")
    private Integer state;

    @ApiModelProperty("")
    private Integer staff;

    @ApiModelProperty("")
    private Date time;

    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    private String remark;

}
