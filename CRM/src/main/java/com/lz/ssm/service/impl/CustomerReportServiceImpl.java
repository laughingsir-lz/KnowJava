package com.lz.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.mapper.CustomerReportMapper;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.qo.CustomerReportQuery;
import com.lz.ssm.service.IReportCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzz
 * @date 2020/8/31  10:44
 */
@Service
public class CustomerReportServiceImpl implements IReportCustomerService {
    @Autowired
    private CustomerReportMapper reportCustomerMapper;

    @Override
    public PageInfo<HashMap> query(QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        return new PageInfo<>(reportCustomerMapper.selectForList(qo));
    }

    @Override
    public List<Map> listAll(CustomerReportQuery qo) {
        return reportCustomerMapper.listAll(qo);
    }
}
