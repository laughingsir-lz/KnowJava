package com.lz.ssm.service.impl;

import com.lz.ssm.domain.CustomerTransfer;
import com.lz.ssm.domain.Employee;
import com.lz.ssm.mapper.CustomerMapper;
import com.lz.ssm.mapper.CustomerTransferMapper;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.service.ICustomerTransferService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerTransferServiceImpl implements ICustomerTransferService {

    @Autowired
    private CustomerTransferMapper customerTransferMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void save(CustomerTransfer customerTransfer) {
        //把客户的销售人员字段改为新的销售人员
        Long customerId = customerTransfer.getCustomer().getId();
        Long sellerId = customerTransfer.getNewSeller().getId();

        customerMapper.updateSeller(customerId, sellerId);
        //--------------保存移交历史记录-------------------
        //设置操作人
        customerTransfer.setOperator((Employee) SecurityUtils.getSubject().getPrincipal());
        //设置操作时间
        customerTransfer.setOperateTime(new Date());

        customerTransferMapper.insert(customerTransfer);
    }

    @Override
    public void delete(Long id) {
        customerTransferMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CustomerTransfer customerTransfer) {
        customerTransferMapper.updateByPrimaryKey(customerTransfer);
    }

    @Override
    public CustomerTransfer get(Long id) {
        return customerTransferMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CustomerTransfer> listAll() {
        return customerTransferMapper.selectAll();
    }

    @Override
    public PageInfo<CustomerTransfer> query(QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize(), "operate_time desc");
        List<CustomerTransfer> customerTransfers = customerTransferMapper.selectForList(qo);
        return new PageInfo<CustomerTransfer>(customerTransfers);
    }
}
