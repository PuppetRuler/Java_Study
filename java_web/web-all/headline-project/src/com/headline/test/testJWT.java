package com.headline.test;

import com.headline.util.JWTUtil;
import org.junit.Test;

/**
 * ClassName:testJWT
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/19 22:05
 * @Version 1.0
 */
public class testJWT {
    @Test
    public void testAllMethod() throws InterruptedException {
        String token = JWTUtil.createToken(1L);
        System.out.println(token);

        Long userId = JWTUtil.getUserId(token);

        System.out.println(JWTUtil.isExpiration(token));

        Thread.sleep(6000);

        System.out.println(JWTUtil.isExpiration(token));
    }
}
