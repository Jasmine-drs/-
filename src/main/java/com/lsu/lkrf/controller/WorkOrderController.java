package com.lsu.lkrf.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsu.lkrf.bean.WorkOrder;
import com.lsu.lkrf.service.WorkOrderService;
import com.lsu.lkrf.tool.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hjj
 * @date 2023/5/20 15:57
 */
@Slf4j
@RestController
@RequestMapping("/workOrders")
@Api(tags = "工单模块")
public class WorkOrderController {
    private WorkOrderService service;
    public WorkOrderController(WorkOrderService service){
        this.service=service;
    }

    @GetMapping
    @ApiOperation(value = "分页查询获取所有工单数据")
    public R<Page<WorkOrder>> getAllPage(
            @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize){
        Page<WorkOrder> page = new Page<>(pageNum,pageSize);
        return R.success(service.page(page));
    }

}
