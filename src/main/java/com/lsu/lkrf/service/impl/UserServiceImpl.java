package com.lsu.lkrf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsu.lkrf.bean.User;
import com.lsu.lkrf.mapper.UserMapper;
import com.lsu.lkrf.service.UserService;
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
    private final QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

    /**
     * 根据id查询用户
     * @param code 用户账号
     * @return 用户
     */
    @Override
    public User selectById(String code) {
        QueryWrapper<User> userQueryWrapper = queryWrapper.eq("code", code);
        return userMapper.selectOne(userQueryWrapper);
    }

    @Override
    public List<String> selectRoles(String id) {
        return userMapper.selectRoleInfo(id);
    }

    @Override
    public List<String> selectPermissionInfo(List<String> roles) {
        return userMapper.selectPermissionInfo(roles);
    }
}




