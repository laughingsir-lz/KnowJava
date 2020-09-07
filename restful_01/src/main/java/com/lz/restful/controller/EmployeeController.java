package com.lz.restful.controller;

import com.lz.restful.domain.Employee;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 * @date 2020/9/6  14:33
 */

/**
 * 使用 @RestController 代替了  @Controller  @ResponseBody 两个注解
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // @RequestMapping(method = RequestMethod.GET)

    /**
     * 使用这个注解  会替代 @RequestMapping(method = RequestMethod.GET)
     * 单个使用 不能在同一个方法上贴多个同类型注解
     */
    @GetMapping
    public List<Employee> list() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1L, "王老吉"));
        list.add(new Employee(2L, "加多宝"));
        list.add(new Employee(3L, "可乐"));
        list.add(new Employee(4L, "乐乐"));
        list.add(new Employee(5L, "擦擦"));
        return list;
    }

    /**
     * @param id 员工id
     * @return
     * @PathVariable 告诉springmvc 去路径上找当前名称的参数 对应的占位符的位置，把参数值设置到形参上
     */
    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return new Employee(id, "测试");
    }

    /**
     * 请求体参数 用对象封装
     * @param employee 员工对象 封装参数
     * @return
     */
    @GetMapping("/{id}/{name}")
    public Employee get(Employee employee) {
        return new Employee(employee.getId(), employee.getName());
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, HttpServletResponse response,String name){
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        System.out.println(id);
        System.out.println(name);
        return "完成删除";
    }

    /**
     * 从路径上获取到少量的参数
     * 当参数多 ，使用请求体带参数
     * @param id
     * @param name
     * @return
     */
    @PutMapping("/{id}/{name}")
    public Employee put(@PathVariable Long id, @PathVariable String name){
        return new Employee(id,name);
    }

    /**
     *
     * @param id 路径上的id 会自动封装到对象中
     * @return
     */
    @PutMapping("/{id}")
    public Employee put(Employee ee){
        return ee;
    }

}
