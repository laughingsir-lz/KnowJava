package com.lz.ssm.service;


import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.SystemDictionary;
import com.lz.ssm.qo.QueryObject;

import java.util.List;

public interface ISystemDictionaryService {
    void save(SystemDictionary systemDictionary);

    void delete(Long id);

    void update(SystemDictionary systemDictionary);

    SystemDictionary get(Long id);

    List<SystemDictionary> listAll();

    // 分页查询的方法
    PageInfo<SystemDictionary> query(QueryObject qo);
}
