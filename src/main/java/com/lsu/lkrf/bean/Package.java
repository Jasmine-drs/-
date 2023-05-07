package com.lsu.lkrf.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private Integer id;

    @NotNull(message="[工种、流程]不能为空")
    @ApiModelProperty("工种、流程")
    private Integer product;

    @NotNull(message="[对应package表]不能为空")
    @ApiModelProperty("对应package表")
    private Integer pac;

    @ApiModelProperty("状态")
    private Integer state;

    @ApiModelProperty("工作人员id")
    private Integer staff;

    @ApiModelProperty("更新时间")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private LocalDateTime time;

    @Size(max= 64,message="编码长度不能超过64")
    @ApiModelProperty("")
    private String remark;

}
