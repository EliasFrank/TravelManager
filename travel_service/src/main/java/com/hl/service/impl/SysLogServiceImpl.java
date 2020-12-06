package com.hl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.dao.SysLogDao;
import com.hl.domain.SysLog;
import com.hl.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hl2333
 */
@Service
@Transactional(rollbackFor = {java.lang.Exception.class})
public class SysLogServiceImpl implements SysLogService{
    @Autowired
    SysLogDao sysLogDao;

    @Override
    public PageInfo<SysLog> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<SysLog> all = sysLogDao.findAll();
        PageInfo<SysLog> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}
