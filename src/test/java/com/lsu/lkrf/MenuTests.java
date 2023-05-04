package com.lsu.lkrf;

import com.lsu.lkrf.bean.Menu;
import com.lsu.lkrf.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2023/5/3 10:04
 */

@SpringBootTest
public class MenuTests {
    @Autowired
    private MenuService menuService;

    @Test
    void getMenuTest() {
        List<Menu> allMenus = menuService.getAllMenus("93");
        allMenus.forEach(System.out::println);
    }

}
