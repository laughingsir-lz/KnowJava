package com.lz.ssm.web.interceptor;

import com.lz.ssm.domain.Employee;
import com.lz.ssm.service.IPermissionService;
import com.lz.ssm.util.RequiredPermission;
import com.lz.ssm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CheckPermissionInterceptor implements HandlerInterceptor {
    @Autowired
    private IPermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 若登录用户是管理员，直接放行
//        Employee employee = (Employee) request.getSession().getAttribute("EMPLOYEE_IN_SESSION");
        Employee employee = UserContext.getCurrentEmployee();
        if (employee.isAdmin()) {
            return true;
        }
// 若不是管理员，获取当前要执行的控制器的处理方法
//HandlerMethod一种可能就是用户访问的控制器处理方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
// 判断 method 中是否贴了权限注解 @RequiredPermission
        RequiredPermission annotation = handlerMethod.getMethodAnnotation(RequiredPermission.class);
        if (annotation == null) {
            // 若没有贴，直接放行
            return true;
        }

// 若贴了权限注解，通过权限注解获取权限表达式
        String expression = annotation.expression();
        // List<String> expressions = permissionService.queryByEmployeeId(employee.getId());
        // List<String> expressions = (List<String>) request.getSession().getAttribute("EXPRESSIONS_IN_SESSION");
        List<String> expressions = UserContext.getCurrentPermission();
        if (expressions.contains(expression)) {
            // 放行
            return true;
        }
        // 转发到没权限的提示页面        
        request.getRequestDispatcher("/WEB-INF/views/common/nopermission.jsp").forward(request, response);
        // 不放行
        return false;
    }
}

