package com.springmvc.header;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:HeaderController
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/3/2 16:49
 * @Version 1.0
 */
@RequestMapping("header")
@Controller
@ResponseBody
public class HeaderController {
    @GetMapping("getHeader")
    public String getHeader(@RequestHeader("content-type") String header){
        System.out.println("header = " + header);
        return "header = " + header;
    }
}
