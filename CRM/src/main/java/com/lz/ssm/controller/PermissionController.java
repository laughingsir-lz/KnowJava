package com.lz.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.Role;
import com.lz.ssm.domain.Permission;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.qo.PageResult;
import com.lz.ssm.qo.PermissionQueryObject;
import com.lz.ssm.service.IRoleService;
import com.lz.ssm.service.IPermissionService;
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
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping("/reload")
    @ResponseBody
    @RequiredPermission(name = "权限加载", expression = "permission:reload")
    public JsonResult reload() {
        try {
            permissionService.reload();
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "权限加载失败");
        }
        return new JsonResult(true, "权限加载成功");
    }

    /**
     * 查看所有角色信息
     *
     * @param model 数据
     * @return 角色信息
     */
    @RequestMapping("/list")
    @RequiredPermission(name = "权限浏览", expression = "permission:list.ftl")
    public String list(@ModelAttribute("qo") PermissionQueryObject qo, Model model) {
        //List<Permission> permissions = permissionService.listAll();
        //分页 过滤
        // PageResult<Permission> permissions = permissionService.query(qo);
        PageInfo<Permission> permissions = permissionService.query(qo);
        model.addAttribute("result", permissions);
        List<Role> roles = roleService.listAll();
        model.addAttribute("roles", roles);
        return "permission/list";
    }

    /**
     * 删除一个角色信息
     *
     * @param id 角色id
     * @return 角色信息页
     */
    @RequestMapping("/delete")
    @ResponseBody
    @RequiredPermission(name = "权限删除", expression = "permission:delete")
    public JsonResult delete(Long id) {
        try {
            if (id != null) {
                permissionService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false, "删除失败");
        }
        return new JsonResult(true, "删除成功");
    }

//    /**
//     * 修改
//     *
//     * @param id    角色id
//     * @param model 数据
//     * @return 修改页
//     */
//    @RequestMapping("/input.ftl")
//    @RequiredPermission(name = "权限编辑", expression = "permission:input.ftl")
//    public String input.ftl(Long id, Model model) {
//        List<Role> roles = roleService.listAll();
//        model.addAttribute("roles", roles);
//        if (id != null) {
//            Permission permission = permissionService.get(id);
//            model.addAttribute("permission", permission);
//        }
//        return "/permission/input.ftl";
//    }

//    /**
//     * 新增或修改
//     *
//     * @param permission 角色对象
//     * @return 角色信息页
//     */
//    @RequestMapping("/saveOrUpdate")
//    public String saveOrUpdate(Permission permission) {
//        if (permission.getId() == null) {
//            //新增
//            permissionService.save(permission);
//        } else {
//            permissionService.update(permission);
//            //修改
//        }
//        // 让浏览器重新发一次请求  
//        return "redirect:/permission/list.ftl";
//    }

}