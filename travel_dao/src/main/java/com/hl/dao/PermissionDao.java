package com.hl.dao;

import com.hl.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hl2333
 */
@Repository
public interface PermissionDao {


    /**
     * 根据权限id删除权限
     * @param id 权限id
     */
    @Delete("delete from permission where id = #{id}")
    void delete(String id);
    /**
     * 根据id查询权限详情
     * @param id 权限id
     * @return 权限信息
     */
    @Select("select * from permission where id = #{id}")
    Permission findById(String id);
    /**
     * 根据权限id查询用户具有的所有权限
     * @param id 权限id
     * @return 用户所具有的所有权限
     */
    @Select("select * from permission where id in " +
            "(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionById(String id);

    /**
     * 查询所有的权限信息
     * @return 所有权限信息
     */
    @Select("select * from permission")
    List<Permission> findAll();

    /**
     * 添加权限
     * @param permission 添加权限
     */
    @Insert("INSERT INTO ssm_travel.permission " +
            "(permissionName, url) " +
            "VALUES (#{permissionName}, #{url})")
    void save(Permission permission);
}
