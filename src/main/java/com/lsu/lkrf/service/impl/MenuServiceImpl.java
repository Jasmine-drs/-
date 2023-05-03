package com.lsu.lkrf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsu.lkrf.bean.Menu;
import com.lsu.lkrf.mapper.MenuMapper;
import com.lsu.lkrf.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jasmine-drs
 * @description 针对表【menu(菜单表)】的数据库操作Service实现
 * @Date 2023-05-03 09:13:09
 */
@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    /**
     * 根据用户id获取菜单
     *
     * @param id 用户id
     * @return 菜单列表
     */
    @Override
    public List<Menu> getAllMenus(String id) {
        if (log.isDebugEnabled()){
            System.out.println("MenuServiceImpl.getAllMenus");
            System.out.println("id = " + id);
        }
        return menuMapper.getAllMenus(id);
    }
}




