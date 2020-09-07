package com.lz.ssm.exception;

import com.alibaba.fastjson.JSON;
import com.lz.ssm.qo.JsonResult;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 该类是针对控制器的增强
 * 利用aop代理实现增强
 */
@ControllerAdvice

public class CrmExceptionHandler {
    /**
     * 代表该方法是用于捕获并处理某种异常的方法
     * e: 代表异常对象
     * method 现在出现异常方法
     */
    @ExceptionHandler(RuntimeException.class)

    public String exceptionHandler(RuntimeException e, HandlerMethod method, HttpServletResponse response) {
        e.printStackTrace();//方便开发的时候找bug
        //如果原本控制器的方法  是返回jsonresult数据  现在出异常也因该返回jsonresult
        //获取当前的出现异常的方法  判断是否有@ResponseBody标签  有就返回json数据
        if (method.hasMethodAnnotation(ResponseBody.class)) {

            try {
                String msg = "操作失败，请联系管理员！";
                if (e instanceof LogicException) {
                    msg = e.getMessage();
                }
                response.setContentType("application/json; charset=UTF-8");
                response.getWriter().print(JSON.toJSONString(new JsonResult(msg)));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return null;
        }
        //如果原本控制器的方法  是返回接送view数据  现在出异常也因该返回view （视图页面）
        // 这里返回的是视图  不能直接返回jsoresult 是因为返回jsonresult会贴注解 @ResponseBody   就不能返回别的类型了
        return "common/error";
    }

    @ExceptionHandler(AuthorizationException.class)
    public String exceptionHandler(AuthorizationException e, HandlerMethod method, HttpServletResponse response) {
        e.printStackTrace();//方便开发的时候找bug
        //如果原本控制器的方法  是返回jsonresult数据  现在出异常也因该返回jsonresult
        //获取当前的出现异常的方法  判断是否有@ResponseBody标签  有就返回json数据
        if (method.hasMethodAnnotation(ResponseBody.class)) {
            response.setContentType("application/json; charset=UTF-8");
            try {
                response.getWriter().print(JSON.toJSONString(new JsonResult("权限不足！")));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return null;
        }
        //如果原本控制器的方法  是返回接送view数据  现在出异常也因该返回view （视图页面）
        // 这里返回的是视图  不能直接返回jsoresult 是因为返回jsonresult会贴注解 @ResponseBody   就不能返回别的类型了

        return "common/nopermission";
    }
}
