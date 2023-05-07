package com.lsu.lkrf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsu.lkrf.bean.Package;
import com.lsu.lkrf.service.PackageService;
import com.lsu.lkrf.mapper.PackageMapper;
import org.springframework.stereotype.Service;

/**
* @author Jasmine-drs
* @description 针对表【package】的数据库操作Service实现
* @createDate 2023-05-07 10:46:26
*/
@Service
public class PackageServiceImpl extends ServiceImpl<PackageMapper, Package>
    implements PackageService{

    private PackageMapper packageMapper;

    public PackageServiceImpl(PackageMapper packageMapper) {
        this.packageMapper = packageMapper;
    }


    @Override
    public Package selectById(String id) {
        QueryWrapper<Package> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return packageMapper.selectOne(wrapper);
    }
}




