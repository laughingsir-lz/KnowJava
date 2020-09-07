package com.lz.ssm.mapper;

import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.qo.CustomerReportQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzz
 * @date 2020/8/31  10:08
 */
public interface CustomerReportMapper {
    List<HashMap> selectForList(QueryObject qo);

    List<Map> listAll(CustomerReportQuery qo);
}
