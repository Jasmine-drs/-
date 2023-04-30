package com.lsu.lkrf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsu.lkrf.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
*
* @description 针对表【user(用户管理，0为普通员工，1为程序操作员，2为管理员)】的数据库操作Mapper
* @createDate 2023-04-30 14:50:58
* @author Jasmine-drs
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select name from role where id=#{id} and state=1")
    List<String> selectRoleInfo(@Param("id") String id);

    List<String> selectPermissionInfo(@Param("roles") List<String> roles);
}
