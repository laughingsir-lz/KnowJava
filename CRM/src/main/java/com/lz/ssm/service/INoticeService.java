package com.lz.ssm.service;

import com.lz.ssm.domain.Notice;
import com.lz.ssm.qo.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface INoticeService {
    void save(Notice notice);

    void delete(Long id);

    void update(Notice notice);

    Notice get(Long id);

    List<Notice> listAll();

    // 分页查询的方法
    PageInfo<Notice> query(QueryObject qo);
}
