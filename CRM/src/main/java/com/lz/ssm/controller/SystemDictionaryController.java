
package com.lz.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.SystemDictionary;
import com.lz.ssm.qo.JsonResult;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.service.ISystemDictionaryService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/systemDictionary")
public class SystemDictionaryController {

    @Autowired
    private ISystemDictionaryService systemDictionaryService;


    @RequiresPermissions(value = {"systemDictionary:list", "字典目录页面"}, logical = Logical.OR)
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo) {
        PageInfo<SystemDictionary> pageInfo = systemDictionaryService.query(qo);
        model.addAttribute("result", pageInfo);
        return "systemdictionary/list";
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = {"systemDictionary:delete", "字典目录删除"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult delete(Long id) {
        if (id != null) {
            systemDictionaryService.delete(id);
        }
        return new JsonResult(true, "删除成功");
    }


    @RequestMapping("/saveOrUpdate")
    @RequiresPermissions(value = {"systemDictionary:saveOrUpdate", "字典目录新增/编辑"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult saveOrUpdate(SystemDictionary systemDictionary) {
        if (systemDictionary.getId() != null) {
            systemDictionaryService.update(systemDictionary);
        } else {
            systemDictionaryService.save(systemDictionary);
        }
        return new JsonResult(true, "修改成功!");
    }
}
