package com.lz.ssm.controller;


import com.lz.ssm.domain.Salary;
import com.lz.ssm.qo.SalaryQueryObject;
import com.lz.ssm.service.IEmployeeService;
import com.lz.ssm.service.ISalaryService;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.service.IDepartmentService;
import com.lz.ssm.service.ISystemDictionaryItemService;
import com.lz.ssm.util.RequiredPermission;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private ISalaryService salaryService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequiresPermissions(value = {"salary:list", "工资管理页面"}, logical = Logical.OR)
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") SalaryQueryObject qo) {
        // 员工下拉菜单
        model.addAttribute("employees", employeeService.listAll());
        model.addAttribute("systemDictionaryItem", systemDictionaryItemService.selectBySourceParentSn("payout"));
        PageInfo<Salary> pageInfo = salaryService.query(qo);
        model.addAttribute("result", pageInfo);
        return "salary/list";
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = {"salary:delete", "工资管理删除"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult delete(Long id) {
        if (id != null) {
            salaryService.delete(id);
        }
        return new JsonResult();
    }


    @RequestMapping("/saveOrUpdate")
    @RequiresPermissions(value = {"salary:saveOrUpdate", "工资管理新增/编辑"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult saveOrUpdate(Salary salary) {
        if (salary.getId() != null) {
            salaryService.update(salary);
        } else {
            salaryService.save(salary);
        }
        return new JsonResult(true, "工资添加成功");
    }
}
