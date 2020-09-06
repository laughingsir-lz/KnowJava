package com.lz.restful.controller;

import com.lz.restful.domain.Employee;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 @RestController 代替了  @Controller  @ResponseBody 两个注解
 * @author zzz
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(params = "id=1")
    public String test1(){
        System.out.println("测试1");
        return "test1";
    }

    @RequestMapping(params = "version=2")
    public String test2(){
        System.out.println("测试2");
        return "test2";
    }

    @RequestMapping(headers = "version=3")
    public String test3(){
        System.out.println("测试3");
        return "test3";
    }
}
