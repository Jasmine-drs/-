package com.lsu.lkrf.tool;

import com.lsu.lkrf.bean.User;
import com.lsu.lkrf.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jasmine-drs
 * @date 2022/11/5 9:42
 */
@Component
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 自定义授权方法
     * 通过 principalCollection 将数据库中的该用户的角色查出来，然后封装给 SimpleAuthorizationInfo
     *
     * @param principalCollection the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return 封装了角色的信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("MyRealm.doGetAuthorizationInfo");
//        获取用户账号
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
//        根据用户账号查询数据库对应的角色信息
        List<String> roles = userService.selectRoles(primaryPrincipal.toString());
//        获取用户的权限信息，细粒度授权才需要权限信息，一般用角色信息就可以授权完成
        List<String> permissionInfo = userService.selectPermissionInfo(roles);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        封装当前用户的角色信息和权限信息
        info.addRoles(roles);
        info.addStringPermissions(permissionInfo);
//        将封装好的角色和权限返回，shiro底层会自动进行权限判断
        return info;
    }

    /**
     * 自定义登录认证方法<br>
     * 通过 authenticationToken 中的用户名，查找数据库中的密码，然后封装进 AuthenticationInfo
     *
     * @param authenticationToken the authentication token containing the user's principal and credentials.
     * @return 封装了用户密码的信息
     * @throws AuthenticationException 认证主体为 null 但不是空字符串
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        获取用户身份信息
        Object principal = authenticationToken.getPrincipal();
        log.info("用户主体{}", principal);
//        获取数据库的用户信息
        User empInfo = userService.selectByCode(principal.toString());
        log.info("getName{}", getName());
        log.info("数据库用户{}", empInfo);
//        非空判断
        AuthenticationInfo info = null;
        if (empInfo != null) {
            info = new SimpleAuthenticationInfo(
                    principal,//    用户主体 Object
                    empInfo.getPassword(),//   数据库中的用户认证信息（密码）
                    ByteSource.Util.bytes("so"), // 加盐信息
                    principal.toString()//  与用户主体对应的名字
            );
        }
        return info;
    }
}
