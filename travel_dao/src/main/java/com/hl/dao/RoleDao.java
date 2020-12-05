package com.hl.dao;

import com.hl.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hl2333
 */
public interface RoleDao {

    /**
     * 查询所有的角色信息
     * @return 所有的角色信息
     */
    @Select("select * from role")
    List<Role> findAll();
    /**
     * 根据用户编号查询用户所有权限
     * @param userId 用户编号
     * @return 用户所有权限
     */
    @Select("select * from role where id in " +
            "(select roleId from users_role where userId = #{userId})")
    public List<Role> findRolesByUserId(String userId);

    /**
     * 根据用户编号查询用户所有权限
     * @param userId 用户编号
     * @return 用户所有权限
     */
    @Select("select * from role where id in " +
            "(select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, column = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.hl.dao.PermissionDao.findPermissionById")
            )
    })
    public List<Role> findRolesDetailByUserId(String userId);

    /**
     * 添加角色信息
     * @param role 角色信息
     */
    @Insert("INSERT INTO ssm_travel.role " +
            "(roleName, roleDesc) " +
            "VALUES (#{roleName}, #{roleDesc})")
    void save(Role role);
}
