package com.lz.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Department;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.domain.Permission;
import com.lz.ssm.domain.Role;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.qo.RoleQueryObject;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.service.IDepartmentService;
import com.lz.ssm.service.IEmployeeService;
import com.lz.ssm.service.IPermissionService;
import com.lz.ssm.service.IRoleService;
import com.lz.ssm.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zzz
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 查看所有角色信息
     *
     * @param model 数据
     * @return 角色信息
     */
    @RequestMapping("/list")
    @RequiredPermission(name = "角色浏览", expression = "role:list.ftl")
    public String list(@ModelAttribute("qo") RoleQueryObject qo, Model model) {
        //PageResult<Role> roles = roleService.query(qo);
        PageInfo<Role> roles = roleService.query(qo);
        model.addAttribute("result", roles);
        return "role/list";
    }

    /**
     * 删除一个角色信息
     *
     * @param id 角色id
     * @return 角色信息页
     */
    @RequestMapping("/delete")
    @ResponseBody
    @RequiredPermission(name = "角色删除", expression = "role:delete")
    public JsonResult delete(Long id) {
        try {
            if (id != null) {
                roleService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "删除失败");
        }
        return new JsonResult(true, "删除成功");
    }

    /**
     * 修改
     *
     * @param id    角色id
     * @param model 数据
     * @return 修改页
     */
    @RequestMapping("/input")
    @RequiredPermission(name = "角色编辑", expression = "role:input.ftl")
    public String input(Long id, Model model) {
        List<Permission> permissions = permissionService.listAll();
        model.addAttribute("permissions", permissions);
        if (id != null) {
            Role role = roleService.get(id);
            model.addAttribute("role", role);
        }
        return "/role/input";
    }

    /**
     * 新增或修改
     *
     * @param role 角色对象
     * @return 角色信息页
     */
    @RequestMapping("/saveOrUpdate")
    @RequiredPermission(name = "角色更新", expression = "role:saveOrUpdate")
    public String saveOrUpdate(Role role, Long ids[]) {
        if (role.getId() == null) {
            //新增
            roleService.save(role, ids);
        } else {
            roleService.update(role, ids);
            //修改
        }
        // 让浏览器重新发一次请求  
        return "redirect:/role/list";
    }

}