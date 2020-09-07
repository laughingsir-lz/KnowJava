package com.lz.ssm.service.impl;

import com.lz.ssm.domain.CustomerTraceHistory;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.mapper.CustomerTraceHistoryMapper;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.service.ICustomerTraceHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTraceHistoryServiceImpl implements ICustomerTraceHistoryService {

    @Autowired
    private CustomerTraceHistoryMapper customerTraceHistoryMapper;


    @Override
    public void save(CustomerTraceHistory customerTraceHistory) {
        customerTraceHistory.setInputUser((Employee) SecurityUtils.getSubject().getPrincipal());
        customerTraceHistoryMapper.insert(customerTraceHistory);
    }

    @Override
    public void delete(Long id) {
        customerTraceHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CustomerTraceHistory customerTraceHistory) {
        customerTraceHistoryMapper.updateByPrimaryKey(customerTraceHistory);
    }

    @Override
    public CustomerTraceHistory get(Long id) {
        return customerTraceHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CustomerTraceHistory> listAll() {
        return customerTraceHistoryMapper.selectAll();
    }

    @Override
    public PageInfo<CustomerTraceHistory> query(QueryObject qo) {
        //对下一句sql进行自动分页
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize(), "trace_time desc");
        //里面不需要自己写limit
        List<CustomerTraceHistory> customerTraceHistorys = customerTraceHistoryMapper.selectForList(qo);
        return new PageInfo<CustomerTraceHistory>(customerTraceHistorys);
    }
}
