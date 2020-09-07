package com.lz.ssm.service.impl;

import com.lz.ssm.domain.Notice;
import com.lz.ssm.mapper.NoticeMapper;
import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.service.INoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public void save(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public void delete(Long id) {
        noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Notice notice) {
        noticeMapper.updateByPrimaryKey(notice);
    }

    @Override
    public Notice get(Long id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Notice> listAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public PageInfo<Notice> query(QueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize()); //对下一句sql进行自动分页
        List<Notice> notices = noticeMapper.selectForList(qo); //里面不需要自己写limit
        return new PageInfo<Notice>(notices);
    }
}
