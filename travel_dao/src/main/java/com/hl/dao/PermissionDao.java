package com.hl.dao;

import com.hl.domain.Permission;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hl2333
 */
public interface PermissionDao {
    /**
     * 根据权限id查询用户具有的所有权限
     * @param id 权限id
     * @return 用户所具有的所有权限
     */
    @Select("select * from permission where id in " +
            "(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionById(String id);
}
