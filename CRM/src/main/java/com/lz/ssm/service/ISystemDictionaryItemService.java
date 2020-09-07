package com.lz.ssm.service;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.SystemDictionaryItem;
import com.lz.ssm.qo.QueryObject;


import java.util.List;

public interface ISystemDictionaryItemService {
    void save(SystemDictionaryItem systemDictionaryItem);

    void delete(Long id);

    void update(SystemDictionaryItem systemDictionaryItem);

    SystemDictionaryItem get(Long id);

    List<SystemDictionaryItem> listAll();


    // 分页查询的方法
    PageInfo<SystemDictionaryItem> query(QueryObject qo);

    List<SystemDictionaryItem> selectBySourceParentSn(String sn);
}
