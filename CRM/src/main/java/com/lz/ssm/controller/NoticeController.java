package com.lz.ssm.controller;


import com.lz.ssm.domain.Notice;
import com.lz.ssm.service.INoticeService;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.qo.QueryObject;
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

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;


    @RequiresPermissions(value = {"notice:list", "公告通知管理页面"}, logical = Logical.OR)
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject qo) {
        PageInfo<Notice> pageInfo = noticeService.query(qo);
        model.addAttribute("pageInfo", pageInfo);
        return "notice/list";
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = {"notice:delete", "公告通知管理删除"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult delete(Long id) {
        if (id != null) {
            noticeService.delete(id);
        }
        return new JsonResult();
    }


    @RequestMapping("/saveOrUpdate")
    @RequiresPermissions(value = {"notice:saveOrUpdate", "公告通知管理新增/编辑"}, logical = Logical.OR)
    @ResponseBody
    public JsonResult saveOrUpdate(Notice notice) {
        if (notice.getId() != null) {
            noticeService.update(notice);
        } else {
            noticeService.save(notice);
        }
        return new JsonResult();
    }
}
