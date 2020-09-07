package com.lz.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Department;
import com.lz.ssm.qo.DepartmentQueryObject;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.service.IDepartmentService;
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


/**
 * @author zzz
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    /**
     * 查看所有部门信息
     *
     * @param model 数据
     * @return 部门信息
     */
    @RequestMapping("/list")
    @RequiredPermission(name = "部门浏览", expression = "department:list.ftl")
    // @RequiresRoles()
    @RequiresPermissions(value = {"department:list.ftl", "部门浏览"}, logical = Logical.OR)
    public String list(@ModelAttribute("qo") DepartmentQueryObject qo, Model model) {
        //  PageResult<Department> departments = departmentService.query(qo);
        PageInfo<Department> departments = departmentService.query(qo);
        if (departments.getPages() == 0) {
            model.addAttribute("page", false);
            return "department/list";
        } else {
            if (departments.getPages() < qo.getCurrentPage()) {
                qo.setCurrentPage(departments.getPages());
//                PageResult<Department> departments2 = departmentService.query(qo);
                PageInfo<Department> departments2 = departmentService.query(qo);
                model.addAttribute("result", departments2);
            } else {
                model.addAttribute("result", departments);
            }
        }
        model.addAttribute("page", true);
        return "department/list";
    }

    /**
     * 删除一个部门信息
     *
     * @param id 部门id
     * @return 部门信息页
     */

    @RequestMapping("/delete")
    @ResponseBody
    //@RequiredPermission(name = "部门删除", expression = "department:delete")
    @RequiresPermissions(value = {"department:delete", "部门删除"}, logical = Logical.OR)
    public JsonResult delete(Long id) {
        try {
            departmentService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "操作失败");
        }
        return new JsonResult(true, "操作成功");
    }

    /**
     * 修改
     *
     * @param id    部门id
     * @param model 数据
     * @return 修改页
     */
    @RequestMapping("/input")
    @RequiredPermission(name = "部门编辑", expression = "department:input.ftl")
    public String input(Long id, Model model) {
        if (id != null) {
            Department department = departmentService.get(id);
            model.addAttribute("department", department);
        }
        return "/department/input";
    }

    /**
     * 新增或修改
     *
     * @param department 部门对象
     * @return 部门信息页
     */
    @RequiredPermission(name = "部门更新", expression = "department:saveOrUpdate")
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JsonResult saveOrUpdate(Department department) {
        try {
            if (department.getId() == null) {
                //新增
                departmentService.save(department);
            } else {
                departmentService.update(department);
                //修改
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "保存失败");
        }
        return new JsonResult(true, "保存成功");
    }
}