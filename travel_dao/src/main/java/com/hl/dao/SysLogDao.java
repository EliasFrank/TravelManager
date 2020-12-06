package com.hl.dao;

import com.hl.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hl2333
 */
@Repository
public interface SysLogDao {
    /**
     * 保存日志信息
     * @param sysLog 日志信息
     */
    @Insert("INSERT INTO ssm_travel.syslog " +
            "(visitTime, username, ip, url, executionTime, method) " +
            "VALUES (#{visitTime}, #{username}, #{ip}, #{url}, #{executionTime}, #{method})")
    void save(SysLog sysLog);

    /**
     * 查询所有日志
     * @return 所有日志
     */
    @Select("select * from syslog")
    List<SysLog> findAll();
}
