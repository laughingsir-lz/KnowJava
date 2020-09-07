package com.lz.ssm.service.impl;

import com.lz.ssm.domain.Customer;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.mapper.CustomerMapper;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.service.ICustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.util.UserContext;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public void save(Customer customer) {
        Employee emp = (Employee) SecurityUtils.getSubject().getPrincipal();
        customer.setInputUser(emp);
        customer.setSeller(emp);
        customer.setInputTime(new Date());
        customerMapper.insert(customer);
    }

    @Override
    public void delete(Long id) {
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public Customer get(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> listAll() {
        return customerMapper.selectAll();
    }

    @Override
    public PageInfo<Customer> query(QueryObject qo) {
        //对下一句sql进行自动分页
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize(), "c.input_time desc");
        //里面不需要自己写limit
        List<Customer> customers = customerMapper.selectForList(qo);
        return new PageInfo<Customer>(customers);
    }
}
