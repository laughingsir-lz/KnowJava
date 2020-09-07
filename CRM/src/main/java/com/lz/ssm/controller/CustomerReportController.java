package com.lz.ssm.controller;


import com.alibaba.fastjson.JSON;
import com.lz.ssm.qo.CustomerReportQuery;
import com.lz.ssm.service.IReportCustomerService;
import com.lz.ssm.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzz
 */
@Controller
@RequestMapping("/customerReport")
public class CustomerReportController {

    @Autowired
    private IReportCustomerService reportCustomerService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") CustomerReportQuery qo) {
        model.addAttribute("result", reportCustomerService.query(qo));
        return "customerReport/list";
    }

    @RequestMapping("/listByBar")
    public String listByBar(Model model, @ModelAttribute("qo") CustomerReportQuery qo) {
        //获取所有数据(不分页)
        List<Map> list = reportCustomerService.listAll(qo);
        //提供一个集合存储x轴的数据
        ArrayList xList = new ArrayList();
        //提供一个集合存储y轴的数据
        ArrayList yList = new ArrayList();
        //需要把数据转换为echart需要结构 x和y轴的数据要分开
        for (Map map : list) {
            xList.add(map.get("groupType"));
            yList.add(map.get("number"));
        }
        //共享到页面(freemarker不能直接显示非字符串的数据(集合,时间))
        System.out.println(JSON.toJSONString(xList));
        model.addAttribute("xList", JSON.toJSONString(xList));
        model.addAttribute("yList", JSON.toJSONString(yList));
        //分组类型转为文字显示
        model.addAttribute("groupTypeName", MessageUtil.changMsg(qo));
        return "customerReport/listByBar";
    }

    @RequestMapping("/listByPie")
    public String listByPie(Model model, @ModelAttribute("qo") CustomerReportQuery qo) {
        //获取所有数据(不分页)
        List<Map> list = reportCustomerService.listAll(qo);
        //提供一个集合存储分组类型的数据
        ArrayList groupTypeValues = new ArrayList();
        //提供一个集合存储饼图的数据
        ArrayList data = new ArrayList();
        //需要把数据转换为echart需要结构
        for (Map map : list) {
            groupTypeValues.add(map.get("groupType"));
            HashMap<String, Object> temp = new HashMap<>();
            temp.put("name", map.get("groupType"));
            temp.put("value", map.get("number"));
            data.add(temp); // {value: 335, name: '孙总'}
        }
        //共享到页面(freemarker不能直接显示非字符串的数据(集合,时间))
        model.addAttribute("groupTypeValues", JSON.toJSONString(groupTypeValues));
        model.addAttribute("data", JSON.toJSONString(data));
        model.addAttribute("groupTypeName", MessageUtil.changMsg(qo));//分组类型
        return "customerReport/listByPie";
    }
}



