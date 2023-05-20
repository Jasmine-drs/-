package com.lsu.lkrf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsu.lkrf.bean.WorkOrder;
import com.lsu.lkrf.mapper.WorkOrderMapper;
import com.lsu.lkrf.service.WorkOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author hjj
 * @date 2023/5/20 16:10
 */
@Service
@Slf4j
public class WorkOrderServiceImpl extends ServiceImpl<WorkOrderMapper, WorkOrder> implements WorkOrderService {

}
