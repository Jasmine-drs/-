package com.lsu.lkrf.controller;

import com.lsu.lkrf.bean.User;
import com.lsu.lkrf.service.UserService;
import com.lsu.lkrf.tool.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2023/4/30 11:01
 */

@Slf4j
@RestController
@RequestMapping("/users")
@Api(tags = "用户模块")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取所有用户
     *
     * @return 所有用户的集合
     */
    @GetMapping
    @ApiOperation(value = "获取所有用户")
    @RequiresPermissions("管理员系统管理")
    public R<List<User>> getAllUser() {
        return R.success(userService.list());
    }


    /**
     * 由 shiro 主导的登录方法
     *
     * @param code       员工id，唯一凭证，用户主体
     * @param password   密码
     * @param rememberMe 是否记住我
     * @return 登录成功
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "员工账号", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "rememberMe", value = "是否记住我", dataTypeClass = Boolean.class)
    })
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public R<String> login(String code, String password, @RequestParam(defaultValue = "false") boolean rememberMe) {
        System.out.println("UserController.login");
//        使用 shiro 进行登录
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(code, password, rememberMe);
//        登录不成功会抛异常，异常统一由异常处理器处理
        subject.login(token);
//        debug模式下，打印登录用户的相关信息
        if (log.isDebugEnabled()) {
            log.info("code=>{}+pwd=>{}+rememberMe=>{}", code, password, rememberMe);
        }
        return R.success("登录成功");
    }
}
