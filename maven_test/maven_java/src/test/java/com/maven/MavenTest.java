package com.maven;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ClassName:MavenTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/24 1:41
 * @Version 1.0
 */
public class MavenTest {

    @Test
    public void testAssert(){
        int a = 10;
        int b = 20;
        Assertions.assertEquals(a+b, 30);
    }

}
