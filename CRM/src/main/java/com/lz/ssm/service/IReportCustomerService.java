package com.lz.ssm.service;

import com.github.pagehelper.PageInfo;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.qo.CustomerReportQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzz
 * @date 2020/8/31  10:43
 */
public interface IReportCustomerService {
    PageInfo<HashMap> query(QueryObject qo);

    List<Map> listAll(CustomerReportQuery qo);
}
