package com.hl.dao;

import com.hl.domain.Permission;
import com.hl.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hl2333
 */
@Repository
public interface RoleDao {

    /**
     * 给角色添加权限
     * @param roleId 角色id
     * @param id 权限id
     */
    @Insert("INSERT INTO ssm_travel.role_permission " +
            "(permissionId, roleId) " +
            "VALUES (#{id}, #{roleId})")
    void addPermission(@Param("roleId") String roleId,
                       @Param("id") String id);
    /**
     * 根据角色id查询角色可以添加的权限
     * @param id 角色id
     * @return 角色可以添加的权限
     */
    @Select("select * from permission where id not in" +
            " (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermission(String id);
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

    /**
     * 查找角色详细信息
     * @param id 角色id
     * @return 角色详细信息
     */
    @Select("SELECT * FROM role where id=#{id}")
    @Results({
            @Result(id = true, column = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.hl.dao.PermissionDao.findPermissionById")
            )
    })
    Role findById(String id);

    /**
     * 根据用户id删除用户信息
     * @param id 用户的id
     */
    @Delete("DELETE FROM ssm_travel.role WHERE id = #{id}")
    void deleteRole(String id);
}
