package com.lz.ssm.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Setter
@Getter
@ToString
public class Salary {
    private Long id;

    private Long money;

    private Integer year;

    private Integer month;

    private Employee employee;

    private SystemDictionaryItem payout;

    // json数据
    public String getJson() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("year", year);
        map.put("month", month);
        map.put("money", money);
        if (employee != null) {
            map.put("employeeId", employee.getId());
        }
        if (payout != null) {
            map.put("payoutId", payout.getId());
        }
        return JSON.toJSONString(map);
    }
}