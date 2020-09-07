package com.lz.ssm.mapper;

import com.lz.ssm.domain.Salary;
import com.lz.ssm.qo.QueryObject;

import java.util.List;

public interface SalaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Salary record);

    Salary selectByPrimaryKey(Long id);

    List<Salary> selectAll();

    int updateByPrimaryKey(Salary record);

    List<Salary> selectForList(QueryObject qo);
}