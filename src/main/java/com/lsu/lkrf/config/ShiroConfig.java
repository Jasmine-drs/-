package com.lsu.lkrf.config;

import com.lsu.lkrf.tool.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * shiro的配置类
 * <p>用于配置加密方式和拦截范围</p>
 *
 * @author Jasmine-drs
 * @date 2022/11/5 9:36
 */
@Configuration
public class ShiroConfig {

    @Resource
    private MyRealm myRealm;

    /**
     * 配置SecurityManager
     * @return 安全管理器
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
//        创建 SecurityManager 对象
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//        创建加密对象，设置相关属性
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
//        设置加密方式和迭代次数
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(3);
//        将加密对象存入到myRealm
        myRealm.setCredentialsMatcher(matcher);
//        将myRealm存入SecurityManager
        defaultWebSecurityManager.setRealm(myRealm);
//        设置 rememberMe
        defaultWebSecurityManager.setRememberMeManager(rememberManager());
        return defaultWebSecurityManager;
    }

    /**
     * 创建 shiro 的 cookie 管理对象
     *
     * @return CookieRememberMeManager
     */
    private CookieRememberMeManager rememberManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
//        16位cookie
        cookieRememberMeManager.setCipherKey("1234567890987654".getBytes());
        return cookieRememberMeManager;
    }

    /**
     * cookie 属性设置
     *
     * @return SimpleCookie
     */
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
//        设置跨域,写允许访问的域的名称
//        cookie.setDomain(domain);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(30 * 24 * 60 * 60);
        return cookie;
    }

    /**
     * 配置拦截范围
     * @return 拦截范围
     */
    @Bean
    public DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        /*设置不认证就可以访问的资源*/
//        放行两个URL，一个是登录页面的URL，一个是后端接口的URL，因为表单提交需要访问这个接口路径
        defaultShiroFilterChainDefinition.addPathDefinition("/user/login", "anon");//   后端接口的URL
        defaultShiroFilterChainDefinition.addPathDefinition("/static/index.html", "anon");
//        配置对应的登出过滤器
        defaultShiroFilterChainDefinition.addPathDefinition("/logout", "logout");
        /*设置需要登录认证的资源路径*/
        defaultShiroFilterChainDefinition.addPathDefinition("/**", "authc");
//        添加存在用户的过滤器 rememberMe
        defaultShiroFilterChainDefinition.addPathDefinition("/**", "user");

        return defaultShiroFilterChainDefinition;
    }

}
