package com.lsu.lkrf;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jasmine-drs
 * @date 2022/11/6 16:35
 */
@SpringBootTest
public class ShiroMD5Test {

    @Test
    void MD5Encryption() {
        String password = "123";

//        普通MD5加密
        Md5Hash md5Hash = new Md5Hash(password);
//        带盐的MD5加密
        Md5Hash md5Hash1 = new Md5Hash(password, "so");
//        带盐的迭代加密
        Md5Hash md5Hash2 = new Md5Hash(password, "so", 3);

        System.out.println("md5Hash = " + md5Hash);
        System.out.println("加盐之后 = " + md5Hash1.toHex());
        System.out.println("加盐迭代 3 次 = " + md5Hash2);
    }
}
