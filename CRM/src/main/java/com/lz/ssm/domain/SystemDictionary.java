package com.lz.ssm.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

/**
 * @author zzz
 */
@ToString
@Setter
@Getter
public class SystemDictionary {
    private Long id;

    private String sn;

    private String title;

    private String intro;

    public String getJson() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("title", title);
        map.put("sn", sn);
        map.put("intro", intro);
        return JSON.toJSONString(map);
    }
}