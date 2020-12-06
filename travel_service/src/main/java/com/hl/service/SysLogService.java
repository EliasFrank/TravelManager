package com.hl.service;

import com.github.pagehelper.PageInfo;
import com.hl.domain.SysLog;

/**
 * @author hl2333
 */
public interface SysLogService {
    /**
     * 保存日志信息
     * @param sysLog 日志信息
     */
    void save(SysLog sysLog);

    /**
     * 查询所有日志
     * @return 所有日志
     * @param page
     * @param size
     */
    PageInfo<SysLog> findAll(Integer page, Integer size);
}
