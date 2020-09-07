package com.lz.ssm.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Department;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.mapper.EmployeeMapper;
import com.lz.ssm.qo.EmployeeQueryObject;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.service.IDepartmentService;
import com.lz.ssm.service.IEmployeeService;
import com.lz.ssm.service.IRoleService;
import com.lz.ssm.util.PasswordUtils;
import com.lz.ssm.util.RequiredPermission;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzz
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IRoleService roleService;

    /**
     * 查看所有员工信息
     *
     * @param model 数据
     * @return 员工信息
     */
    @RequestMapping("/list")
    @RequiredPermission(name = "员工浏览", expression = "employee:list.ftl")
    public String list(@ModelAttribute("qo") EmployeeQueryObject qo, Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.hasRole("HR_MGR");
        subject.isPermitted();
        System.out.println("当前用户是否有admin角色："
                + SecurityUtils.getSubject().hasRole("admin"));
        System.out.println("当前登录用户是否有employee:delete权限："
                + SecurityUtils.getSubject().isPermitted("employee:delete"));
        if (subject.isPermitted("employee:list")) {
            //分页 过滤
            //PageResult<Employee> employees = employeeService.query(qo);
            PageInfo<Employee> employees = employeeService.query(qo);
            model.addAttribute("result", employees);
            List<Department> departments = departmentService.listAll();
            model.addAttribute("depts", departments);
            return "employee/list";
        }

        return "common/nopermission";
    }

    /**
     * 删除一个员工信息
     *
     * @param id 员工id
     * @return 员工信息页
     */
    @RequestMapping("/delete")
    @ResponseBody
    @RequiredPermission(name = "员工删除", expression = "employee:delete")
    public JsonResult delete(Long id) {
        int i = 1 / 0;
        if (id != null) {
            employeeService.delete(id);
        }
        return new JsonResult(true, "删除成功");
    }

    /**
     * 修改
     *
     * @param id    员工id
     * @param model 数据
     * @return 修改页
     */
    @RequestMapping("/input")
    @RequiredPermission(name = "员工编辑", expression = "employee:input.ftl")
    public String input(Long id, Model model) {
        List<Department> departments = departmentService.listAll();
        model.addAttribute("departments", departments);
        model.addAttribute("roles", roleService.listAll());
        if (id != null) {
            Employee employee = employeeService.get(id);
            model.addAttribute("employee", employee);
        }
        return "/employee/input";
    }

    /**
     * 新增或修改
     *
     * @param employee 员工对象
     * @return 员工信息页
     */
    @RequestMapping("/saveOrUpdate")
    @RequiredPermission(name = "员工更新", expression = "employee:saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(Employee employee, Long[] ids) {
        try {
            if (employee.getId() == null) {
                //新增
                employeeService.save(employee, ids);
            } else {

                employeeService.update(employee, ids);
                //修改
            }
            return new JsonResult(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(true, "添加失败");
        }

    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public JsonResult batchDelete(Long[] ids) {
        if (ids != null && ids.length > 0) {
            employeeService.batchDelete(ids);
        }
        return new JsonResult(true, "批量删除成功");
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public Map checkName(String name, Long id) {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("valid", (employeeService.selectByName(name) == null || (id != null && employeeService.get(id).getName().equals(name))));
        return map;
    }

    @RequestMapping("/exportXls")
    public void export(HttpServletResponse response) throws IOException {
        Workbook wb = employeeService.export();
        //文件下载的响应头
        response.setHeader("Content-Disposition", "attachment; filename=employeeInfo.xlsx");
        //输出类容到响应流
        wb.write(response.getOutputStream());
    }

    @RequestMapping("/importXls")
    @ResponseBody
    public JsonResult importXls(MultipartFile file) throws Exception {
        employeeService.inport(file);
        return new JsonResult(true, "数据已成功导入！");
    }

    @RequestMapping("/update")
    public String update() {

        return "/employee/updatePwd";
    }

    @RequestMapping("/checkPassword")
    @ResponseBody
    public Map checkPassword(String oldPassword) {// 拿到当前对象
        Employee emp = (Employee) SecurityUtils.getSubject().getPrincipal();
        //旧密码
        String password = emp.getPassword();
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("valid", (oldPassword != null && PasswordUtils.md5Pwd(oldPassword, emp.getName()).equals(password)));
        return map;
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public JsonResult updatePassword(String oldPassword, String newPassword) {
//        // 拿到当前对象
//        Employee emp = (Employee) SecurityUtils.getSubject().getPrincipal();
//        //旧密码
//        String password = emp.getPassword();
//      if(password.equals(oldPassword)){
        Employee emp = (Employee) SecurityUtils.getSubject().getPrincipal();
        String md5Pwd = PasswordUtils.md5Pwd(newPassword, emp.getName());
        emp.setPassword(md5Pwd);
        employeeService.updateByPrimaryKey(emp);
        return new JsonResult(true, "修改成功");
//      }
//        return new JsonResult(false,"修改失败");
    }

    @RequestMapping("/disable")
    @ResponseBody
    public JsonResult disable(Long id) {
        if (id != null) {
            employeeService.disableStatus(id);
        }
        return new JsonResult(true, "账号禁用！");

    }

    @RequestMapping("/xxx")
    @ResponseBody
    public JsonResult start(Long id) {
        if (id != null) {
            employeeService.startStatus(id);
            return new JsonResult(true, "账号已成功启用！");
        } else {
            return new JsonResult(true, "账号启用失败！");
        }
    }

    @RequestMapping("/checkStatus")
    @ResponseBody
    public JsonResult checkStatus(Long id) {
        if (id != null) {
            employeeService.updateStatus(id);
            return new JsonResult(true, "账号已成功启用！");
        } else {
            return new JsonResult(false, "系统故障！请联系管理员！！！");
        }
    }
}