package com.lsu.lkrf.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hjj
 * @date 2023/5/20 12:08
 */
@Data
@ApiModel(value="WorkOrder对象", description="工单对象")
@TableName("work_order")
public class WorkOrder {
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Integer id;

    @NotNull(message="[订单号]不能为空")
    @ApiModelProperty("订单号")
    @TableField("co_nbr")
    private String coNbr;

    @TableField("queue_name")
    @ApiModelProperty("流程名称")
    private String  queueName;

    @TableField("queue_id")
    @ApiModelProperty("流程id")
    private Integer queueId; //queue

    @NotNull(message="[流转单号]不能为空")
    @ApiModelProperty("流转单号")
    @TableField("wf_nbr")
    private String wfNbr;


    @ApiModelProperty("领料数量")
    private Integer num;


    @ApiModelProperty("领料重量")
    private Double unit;


    @ApiModelProperty("产品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty("产品id")
    @TableField("product_id")
    private Integer productId;//product

    @ApiModelProperty("材料名称")
    @TableField("material_name")
    private String materialName;

    @ApiModelProperty("材料id")
    @TableField("material_id")
    private Integer materialId;//material

    @ApiModelProperty("完工数量")
    @TableField("num_cp")
    private Integer numCp;

    @ApiModelProperty("完工重量")
    @TableField("unit_cp")
    private Double unitCp;

    @ApiModelProperty("良品率")
    @TableField("pass_rate")
    private Double passRate;

    @ApiModelProperty("工人")
    @TableField("operator_name")
    private String operatorName;

    @ApiModelProperty("工人id")
    @TableField("operator_id")
    private Integer operatorId;//operator

    @ApiModelProperty("设备名")
    @TableField("equipment_name")
    private String equipmentName;

    @ApiModelProperty("设备id")
    @TableField("equipment_id")
    private Integer equipmentId;//equipment

    @ApiModelProperty("机修工")
    @TableField("mechanic_name")
    private String mechanicName;
    @ApiModelProperty("机修工id")
    @TableField("mechanic_id")
    private Integer mechanicId;//mechanic

    @ApiModelProperty("状态")
    @TableField("state_name")
    private String stateName;
    @ApiModelProperty("状态id")
    @TableField("state_id")
    private Integer stateId;//state

    @ApiModelProperty("操作员")
    @TableField("staff_name")
    private String staffName;
    @ApiModelProperty("操作员id")
    @TableField("staff_id")
    private Integer staffId;//staff
}
