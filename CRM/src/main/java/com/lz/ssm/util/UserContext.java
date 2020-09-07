package com.lz.ssm.util;

import com.lz.ssm.domain.Employee;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserContext {
    public static final String EMPLOYEE_IN_SESSION = "EMPLOYEE_IN_SESSION";
    public static final String EXPRESSIONS_IN_SESSION = "EXPRESSIONS_IN_SESSION";

    private UserContext() {
    }

    //获取session的方法
    public static HttpSession getSession() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest().getSession();
    }

    /**
     * 往session中存入员工对象
     */
    public static void setCurrentEmployee(Employee employee) {
        //怎么获取到session 对象 （参数不能随便传）
        getSession().setAttribute(EMPLOYEE_IN_SESSION, employee);

    }

    //从 session 获取登录用户
    public static Employee getCurrentEmployee() {
        return (Employee) getSession().getAttribute(EMPLOYEE_IN_SESSION);
    }

    public static void setCurrentPermission(List<String> permissions) {
        getSession().setAttribute(EXPRESSIONS_IN_SESSION, permissions);

    }
    //往 session 存入登录用户的权限信息    


    //从 session 获取登录用户的权限信息
    public static List<String> getCurrentPermission() {
        return (List<String>) getSession().getAttribute(EXPRESSIONS_IN_SESSION);
    }
}
