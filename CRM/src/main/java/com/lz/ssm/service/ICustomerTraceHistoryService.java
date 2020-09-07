package com.lz.ssm.service;

import com.lz.ssm.domain.CustomerTraceHistory;
import com.lz.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICustomerTraceHistoryService {
    void save(CustomerTraceHistory customerTraceHistory);

    void delete(Long id);

    void update(CustomerTraceHistory customerTraceHistory);

    CustomerTraceHistory get(Long id);

    List<CustomerTraceHistory> listAll();

    // 分页查询的方法
    PageInfo<CustomerTraceHistory> query(QueryObject qo);
}
