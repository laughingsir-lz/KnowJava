package com.lz.ssm.domain;

/**
 * @author zzz
 * @date 2020/8/29  9:50
 */

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashMap;

@Setter
@Getter
@ToString
public class Customer {
    /**
     * STATUS_COMMON = 0;    潜在客户
     * STATUS_NORMAL = 1;    正式客户
     * STATUS_FAIL = 2;      开发失败
     * STATUS_LOST = 3;      流失客户
     * STATUS_POOL = 4;      客户池
     */
    public static final int STATUS_COMMON = 0;
    public static final int STATUS_NORMAL = 1;
    public static final int STATUS_FAIL = 2;
    public static final int STATUS_LOST = 3;
    public static final int STATUS_POOL = 4;


    /**
     * ;
     * name;
     * age;
     * gender;
     * tel;
     * qq;
     * job;
     * source;
     * seller;
     * inputUser;
     * inputTime;
     * status = STATUS_COMMON;
     */
    private Long id;

    private String name;
    //年龄
    private Integer age;
    //性别
    private Integer gender;
    //电话
    private String tel;
    //qq
    private String qq;
    //职业
    private SystemDictionaryItem job;
    //来源
    private SystemDictionaryItem source;
    //销售人员
    private Employee seller;
    //录入人
    private Employee inputUser;
    //录入时间
    @DateTimeFormat()
    private Date inputTime;
    //状态
    private Integer status = STATUS_COMMON;

    // 状态名
    public String getStatusName() {
        switch (status) {
            case STATUS_NORMAL:
                return "正式客户";
            case STATUS_FAIL:
                return "开发失败客户";
            case STATUS_LOST:
                return "流失客户";
            case STATUS_POOL:
                return "客户池";
            default:
                return "潜在客户";
        }
    }

    // json数据
    public String getJson() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("age", age);
        map.put("gender", gender);
        map.put("tel", tel);
        map.put("qq", qq);
        if (job != null) {
            map.put("jobId", job.getId());
        }
        if (source != null) {
            map.put("sourceId", source.getId());
        }
        if (seller != null) {
            map.put("sellerId", seller.getId());
            map.put("sellerName", seller.getName());
        }
        return JSON.toJSONString(map);

    }

    // private CustomerTraceHistory trace;
    private Integer count;

}