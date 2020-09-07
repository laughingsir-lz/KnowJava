package com.lz.ssm.controller;

import com.lz.ssm.domain.Employee;
import com.lz.ssm.exception.LogicException;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.service.IEmployeeService;
import com.lz.ssm.service.IPermissionService;
import com.lz.ssm.util.PasswordUtils;
import com.lz.ssm.util.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/loginin")
    @ResponseBody
    public JsonResult login(String username, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            //单独查询这个用户的盐
            UsernamePasswordToken token = null;

            try {
                Employee employee = employeeService.selectByName(username);
                String md5Pwd = PasswordUtils.md5Pwd(password, employee.getSalt());
                token = new UsernamePasswordToken(username, md5Pwd);
            } catch (Exception e) {
                e.printStackTrace();
                throw new LogicException("账户不存在！");
                // return new JsonResult(false, "账号或者密码错误！");
            }
            subject.login(token);
            Employee emp = (Employee) subject.getPrincipal();
            if (emp.isStatus()) {
                return new JsonResult(true, "登录成功");
            } else {
                return new JsonResult(false, "账号已禁用！");
            }

        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new JsonResult(false, "账号或者密码错误！");
        }
    }
}
