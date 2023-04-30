package com.lsu.lkrf.exception;

import com.lsu.lkrf.tool.R;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义异常处理器
 * @author Jasmine-drs
 * @date 2022/11/3 18:26
 */
@RestControllerAdvice
public class HandelException {

    //    拦截所有异常,处理后返回统一格式
    @ExceptionHandler
    public R<String> doException(Exception e) {
//        记录日志
//        通知各级
//        处理异常
        e.printStackTrace();
        return R.err("服务器异常，请稍后再试！");
    }

    /**
     * 处理数据完整性违规异常
     *
     * @param e 数据完整性违规异常
     * @return 提示信息
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public R<String> dataIntegrityViolationException(DataIntegrityViolationException e) {
        e.printStackTrace();
        return R.err("数据重复或长度越界");
    }

    /**
     * 处理自定义异常
     *
     * @param e 自定义异常
     * @return 提示信息
     */
    @ExceptionHandler(SystemException.class)
    public R<String> SystemException(SystemException e) {
        e.printStackTrace();
        return R.err(e.getMessage());
    }

    /**
     * 处理用户名错误异常
     *
     * @param e 用户名错误异常
     * @return 统一返回结果类
     */
    @ExceptionHandler(UnknownAccountException.class)
    public R<String> unknownAccountException(UnknownAccountException e) {
        e.printStackTrace();
        return R.err("用户名错误");
    }

    /**
     * 处理密码错误异常
     *
     * @param e 密码错误异常
     * @return 统一返回结果类
     */
    @ExceptionHandler(IncorrectCredentialsException.class)
    public R<String> incorrectCredentialsException(IncorrectCredentialsException e) {
        e.printStackTrace();
        return R.err("密码错误");
    }

    /**
     * 未登录直接访问网址，或登录状态已过期
     *
     * @param e 身份验证异常
     * @return 统一返回结果类
     */
    @ExceptionHandler(AuthenticationException.class)
    public R<String> authenticationException(AuthenticationException e) {
        e.printStackTrace();
        return R.err("请先登录");
    }

    /**
     * 权限校验失败异常
     *
     * @param e 异常
     * @return 提示信息
     */
    @ExceptionHandler(UnauthorizedException.class)
    public R<String> UnauthorizedException(UnauthorizedException e) {
        e.printStackTrace();
        return R.err("对不起，你无权进行此操作");
    }

    /**
     * 处理参数接收不到的异常
     *
     * @param e 异常
     * @return 提示信息
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R<String> MissingServletRequestParameterException(MissingServletRequestParameterException e) {
        e.printStackTrace();
        return R.err("携带参数缺失");
    }
}
