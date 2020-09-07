package com.lz.ssm.mapper;

import com.lz.ssm.domain.SystemDictionaryItem;
import com.lz.ssm.qo.QueryObject;

import java.util.List;

public interface SystemDictionaryItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    List<SystemDictionaryItem> selectAll();

    int updateByPrimaryKey(SystemDictionaryItem record);

    List<SystemDictionaryItem> selectForList(QueryObject qo);

    List<SystemDictionaryItem> selectBySourceParentSn(String sn);
}