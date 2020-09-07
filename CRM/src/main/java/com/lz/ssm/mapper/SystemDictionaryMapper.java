package com.lz.ssm.mapper;

import com.lz.ssm.domain.SystemDictionary;
import com.lz.ssm.qo.QueryObject;

import java.util.List;

public interface SystemDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionary record);

    SystemDictionary selectByPrimaryKey(Long id);

    List<SystemDictionary> selectAll();

    int updateByPrimaryKey(SystemDictionary record);

    List<SystemDictionary> selectForList(QueryObject qo);
}