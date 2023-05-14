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

import javax.validation.constraints.NotNull;
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
    public R<User> login(String code, String password, @RequestParam(defaultValue = "false") boolean rememberMe) {
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
        return R.success(userService.selectOne(code,password));
    }

    /**
     * 登出方法
     *
     * @return 登出成功
     */
    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    @RequiresPermissions("通用权限（最低）")
    public R<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.success("登出成功");
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 所有用户的集合
     */
    @ApiOperation(value = "添加用户")
    @PostMapping
    @RequiresPermissions("管理员系统管理")
    @NotNull(message = "用户对象不能为空")
    public R<List<User>> addUser(@RequestBody User user) {
        userService.save(user);
        return R.success(userService.list());
    }
//TODO
    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 所有用户的集合
     */
    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    @RequiresPermissions("管理员系统管理")
    @NotNull(message = "用户id不能为空")
    public R<List<User>> deleteUser(@PathVariable Integer id) {
        boolean b = userService.removeById(id);
        if (!b) {
            return R.err("删除失败,该用户不存在或已被删除");
        }
        return R.success(userService.list());
    }

    /**
     * 用户修改自身信息
     *
     * @param user 用户对象
     * @return 用户信息
     */
    @ApiOperation(value = "修改用户")
    @PutMapping
    @RequiresPermissions("管理员系统管理")
    @NotNull(message = "用户对象不能为空")
    public R<User> updateUser(@RequestBody User user) {
        boolean b = userService.updateById(user);
        if (!b) {
            return R.err("修改失败,该用户不存在或已被删除");
        }
        return R.success(userService.getById(user.getId()));
    }

}
