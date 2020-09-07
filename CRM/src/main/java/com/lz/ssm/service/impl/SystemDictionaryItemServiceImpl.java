package com.lz.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lz.ssm.domain.SystemDictionaryItem;
import com.lz.ssm.mapper.SystemDictionaryItemMapper;

import com.lz.ssm.qo.QueryObject;
import com.lz.ssm.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemDictionaryItemServiceImpl implements ISystemDictionaryItemService {

    @Autowired
    private SystemDictionaryItemMapper systemDictionaryItemMapper;


    @Override
    public void save(SystemDictionaryItem systemDictionaryItem) {
        systemDictionaryItemMapper.insert(systemDictionaryItem);
    }

    @Override
    public void delete(Long id) {
        systemDictionaryItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(SystemDictionaryItem systemDictionaryItem) {
        systemDictionaryItemMapper.updateByPrimaryKey(systemDictionaryItem);
    }

    @Override
    public SystemDictionaryItem get(Long id) {
        return systemDictionaryItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemDictionaryItem> listAll() {
        return systemDictionaryItemMapper.selectAll();
    }

    @Override
    public PageInfo<SystemDictionaryItem> query(QueryObject qo) {
        //对下一句sql进行自动分页
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
        //里面不需要自己写limit
        List<SystemDictionaryItem> systemDictionaryItems = systemDictionaryItemMapper.selectForList(qo);
        return new PageInfo<SystemDictionaryItem>(systemDictionaryItems);
    }

    @Override
    public List<SystemDictionaryItem> selectBySourceParentSn(String sn) {
        return systemDictionaryItemMapper.selectBySourceParentSn(sn);
    }
}
