package com.spring.resource;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

/**
 * ClassName:URLResourceDemo
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/27 12:39
 * @Version 1.0
 */
// 演示UrlResource访问网络资源
public class URLResourceDemo {

    public static void main(String[] args) {
        loadUrlResource("http://www.baidu.com");
        loadUrlResource("file:ciallo.txt");
    }

    // 访问前缀http、file
    public static void loadUrlResource(String path){
        try {
            // 创建Resource实现类的对象 UrlResource
            UrlResource url = new UrlResource(path);

            //获取资源信息
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}
