package com.lsu.lkrf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsu.lkrf.bean.User;
import com.lsu.lkrf.mapper.UserMapper;
import com.lsu.lkrf.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @description 针对表【user(用户管理，0为普通员工，1为程序操作员，2为管理员)】的数据库操作Service实现
 * @Date 2023-04-30 10:44:18
 * @author Jasmine-drs
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    /**
     * 根据账号查询用户
     * @param code 用户账号
     * @return 用户
     */
    @Override
    public User selectByAccount(String code) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> userQueryWrapper = queryWrapper.eq("code", code);
        return userMapper.selectOne(userQueryWrapper);
    }

    /**
     * 根据用户id查询用户角色
     * @param id 用户id
     * @return 用户角色
     */
    @Override
    public List<String> selectRoles(String id) {
        return userMapper.selectRoleInfo(id);
    }

    /**
     * 根据用户角色查询用户权限
     * @param roles 用户角色
     * @return 用户权限
     */
    @Override
    public List<String> selectPermissionInfo(List<String> roles) {
        return userMapper.selectPermissionInfo(roles);
    }

    /**
     * 根据账号和密码查询用户
     * @param code 账号
     * @param password 密码
     * @return 用户
     */
    @Override
    public User selectOne(String code, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Md5Hash md5Hash2 = new Md5Hash(password, "so", 3);
        QueryWrapper<User> userQueryWrapper = queryWrapper.eq("code",code).eq("password", md5Hash2.toString());
        return userMapper.selectOne(userQueryWrapper);
    }
}




