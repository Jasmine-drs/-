package com.lsu.lkrf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsu.lkrf.bean.User;

import java.util.List;

/**
 *
 * @description 针对表【user(用户管理，0为普通员工，1为程序操作员，2为管理员)】的数据库操作Service
 * @Date 2023-04-30 10:44:18
 * @author Jasmine-drs
 */
public interface UserService extends IService<User> {

    User selectByAccount(String code);

    List<String> selectRoles(String id);

    List<String> selectPermissionInfo(List<String> roles);

    public User selectOne(String code, String password);
}
