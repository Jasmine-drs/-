package com.lsu.lkrf.controller;

import com.lsu.lkrf.bean.Package;
import com.lsu.lkrf.service.PackageService;
import com.lsu.lkrf.tool.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2023/5/7 10:51
 */
@RestController
@RequestMapping("/packages")
@Api(tags = "package模块")
public class PackageController {

    private PackageService packageService;


    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    @ApiOperation("获取所有package")
    public R<List<Package>> getAll(){
        List<Package> list = packageService.list();
        System.out.println("list = " + list);
        return R.success(list);
    }

    @GetMapping("/{id}")
    @ApiOperation("查找指定的package")
    @ApiImplicitParam(name = "id", value = "唯一索引", readOnly = true, dataTypeClass = Integer.class)
    public R<Package> getOnePackage(@PathVariable String id){
        System.out.println("PackageController.getOnePackage");
        Package aPackage = packageService.selectById(id);
        System.out.println("aPackage = " + aPackage);
        if (aPackage==null){
            return R.err("没有找到package");
        }
        return R.success(aPackage);
    }
}
