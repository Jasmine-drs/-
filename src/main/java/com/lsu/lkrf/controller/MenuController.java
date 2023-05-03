package com.lsu.lkrf.controller;

import com.lsu.lkrf.bean.Menu;
import com.lsu.lkrf.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2023/5/3 9:22
 */

@Slf4j
@RestController
@RequestMapping("/menus")
@Api(tags = "菜单模块")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * 根据用户id获取菜单
     * @param id    用户id
     * @return  菜单列表
     */
    @GetMapping("{id}")
    @RequiresPermissions("通用权限（最低）")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "String")
    public List<Menu> getAllMenus(@PathVariable String id){
        log.info("id:{}",id);
        return menuService.getAllMenus(id);
    }

}
