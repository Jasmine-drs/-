package com.lsu.lkrf.service;

import com.lsu.lkrf.bean.Package;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Jasmine-drs
* @description 针对表【package】的数据库操作Service
* @createDate 2023-05-07 10:46:26
*/
public interface PackageService extends IService<Package> {

    Package selectById(String id);
}
