package com.lz.ssm.controller;


import com.lz.ssm.domain.CustomerTraceHistory;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.qo.CustomerQueryObject;
import com.lz.ssm.service.ICustomerTraceHistoryService;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.service.IDepartmentService;
import com.lz.ssm.service.IEmployeeService;
import com.lz.ssm.util.RequiredPermission;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customerTraceHistory")
public class CustomerTraceHistoryController {

    @Autowired
    private ICustomerTraceHistoryService customerTraceHistoryService;
    @Autowired
    private IEmployeeService employeeService;

    @RequiresPermissions(value = {"customerTraceHistory:list", "跟进历史页面"}, logical = Logical.OR)
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") CustomerQueryObject qo) {
        model.addAttribute("sellers", employeeService.selectByRoleSn("Market", "Market_Manager"));
        Subject subject = SecurityUtils.getSubject();

        if (!subject.hasRole("ADMIN") && !subject.hasRole("Market_Manager")) {
            qo.setSellerId(((Employee) subject.getPrincipal()).getId());
        }
        PageInfo<CustomerTraceHistory> pageInfo = customerTraceHistoryService.query(qo);
        model.addAttribute("result", pageInfo);
        return "customerTraceHistory/list";
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = {"customerTraceHistory:delete", "跟进历史删除"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult delete(Long id) {
        if (id != null) {
            customerTraceHistoryService.delete(id);
        }
        return new JsonResult();
    }


    @RequestMapping("/saveOrUpdate")
    @RequiresPermissions(value = {"customerTraceHistory:saveOrUpdate", "跟进历史新增/编辑"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult saveOrUpdate(CustomerTraceHistory customerTraceHistory) {
        if (customerTraceHistory.getId() != null) {
            customerTraceHistoryService.update(customerTraceHistory);
        } else {
            customerTraceHistoryService.save(customerTraceHistory);
        }
        return new JsonResult(true, "跟进记录已生成！请前往查看！");
    }
}
