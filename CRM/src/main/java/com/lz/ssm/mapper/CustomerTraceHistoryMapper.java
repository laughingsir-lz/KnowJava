package com.lz.ssm.mapper;

import com.lz.ssm.domain.CustomerTraceHistory;
import com.lz.ssm.qo.QueryObject;

import java.util.List;

public interface CustomerTraceHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerTraceHistory record);

    CustomerTraceHistory selectByPrimaryKey(Long id);

    List<CustomerTraceHistory> selectAll();

    int updateByPrimaryKey(CustomerTraceHistory record);

    List<CustomerTraceHistory> selectForList(QueryObject qo);
}