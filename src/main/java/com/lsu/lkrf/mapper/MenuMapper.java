package com.lsu.lkrf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsu.lkrf.bean.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @description 针对表【menu(菜单表)】的数据库操作Mapper
 * @Date 2023-05-03 09:13:09
 * @author Jasmine-drs
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户id获取菜单
     * @param id   用户id
     * @return  菜单列表
     */
    List<Menu> getAllMenus(@Param(value = "id") String id);
}




