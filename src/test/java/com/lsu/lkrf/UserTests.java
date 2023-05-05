package com.lsu.lkrf;

import com.lsu.lkrf.bean.User;
import com.lsu.lkrf.controller.UserController;
import com.lsu.lkrf.mapper.UserMapper;
import com.lsu.lkrf.tool.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Jasmine-drs
 * @date 2023/5/5 10:39
 */

@SpringBootTest
public class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserController userController;
    @Autowired
    private WebApplicationContext context;

    @Test
    void testPermissions() {
        // 调用 Controller 接口方法前添加以下代码
        SecurityManager securityManager = context.getBean(SecurityManager.class);
        SecurityUtils.setSecurityManager(securityManager);
        R<User> userR = userController.login("fdq", "123", true);
        System.out.println("userR = " + userR);
//        R<List<User>> allUser = userController.getAllUser();
//        System.out.println("allUser = " + allUser);
    }
}
