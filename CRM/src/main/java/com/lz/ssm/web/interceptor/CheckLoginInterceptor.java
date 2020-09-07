package com.lz.ssm.web.interceptor;

import com.lz.ssm.util.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取当前登录的用户
        // Object employee = request.getSession().getAttribute("EMPLOYEE_IN_SESSION");
        Object employee = UserContext.getCurrentEmployee();
        if (employee == null) {
            // 没有登录，不放行            
            response.sendRedirect("/login.html");
            // 回到登录界面
            return false;
        }
        // 已经登录则放行  
        return true;
    }
}

