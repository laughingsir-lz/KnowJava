package com.lz.ssm.controller;


import com.lz.ssm.domain.Customer;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.qo.CustomerQueryObject;
import com.lz.ssm.service.ICustomerService;
import com.github.pagehelper.PageInfo;

import com.lz.ssm.qo.JsonResult;


import com.lz.ssm.service.IEmployeeService;
import com.lz.ssm.service.ISystemDictionaryItemService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzz
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;
    @Autowired
    private IEmployeeService employeeService;


    @RequiresPermissions(value = {"customer:list", "客户列表页面"}, logical = Logical.OR)
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") CustomerQueryObject qo) {
        PageInfo<Customer> pageInfo = customerService.query(qo);
        // 高级查询的销售人员
        model.addAttribute("sellers", employeeService.selectByRoleSn("Market", "Market_Manager"));
        model.addAttribute("result", pageInfo);
        // 职业下拉框
        model.addAttribute("jobs", systemDictionaryItemService.selectBySourceParentSn("job"));
        // 来源下拉框
        model.addAttribute("sources", systemDictionaryItemService.selectBySourceParentSn("source"));
        // 交流方式
        model.addAttribute("ccts", systemDictionaryItemService.selectBySourceParentSn("communicationMethod"));
        return "customer/list";
    }

    @RequiresPermissions(value = {"customer:potentialList", "潜在客户页面"}, logical = Logical.OR)
    @RequestMapping("/potentialList")
    public String potentialList(Model model, @ModelAttribute("qo") CustomerQueryObject qo) {
        qo.setStatus(Customer.STATUS_COMMON);
        Subject subject = SecurityUtils.getSubject();

        if (!subject.hasRole("ADMIN") && !subject.hasRole("Market_Manager")) {
            qo.setSellerId(((Employee) subject.getPrincipal()).getId());
        }
        PageInfo<Customer> pageInfo = customerService.query(qo);
        // 高级查询的销售人员
        model.addAttribute("sellers", employeeService.selectByRoleSn("Market", "Market_Manager"));
        model.addAttribute("result", pageInfo);
        // 职业下拉框
        model.addAttribute("jobs", systemDictionaryItemService.selectBySourceParentSn("job"));
        // 来源下拉框
        model.addAttribute("sources", systemDictionaryItemService.selectBySourceParentSn("source"));
        // 交流方式
        model.addAttribute("ccts", systemDictionaryItemService.selectBySourceParentSn("communicationMethod"));
        return "customer/potentialList";
    }


    @RequestMapping("/delete")
    @RequiresPermissions(value = {"customer:delete", "潜在客户删除"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult delete(Long id) {
        if (id != null) {
            customerService.delete(id);
        }
        return new JsonResult();
    }


    @RequestMapping("/saveOrUpdate")
    @RequiresPermissions(value = {"customer:saveOrUpdate", "潜在客户新增/编辑"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult saveOrUpdate(Customer customer) {
        if (customer.getId() != null) {
            customerService.update(customer);
        } else {
            customerService.save(customer);
        }
        return new JsonResult(true, "潜在客户更新成功！");
    }
}
