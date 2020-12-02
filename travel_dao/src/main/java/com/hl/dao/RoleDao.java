package com.hl.dao;

import com.hl.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hl2333
 */
public interface RoleDao {

    /**
     * 根据用户编号查询用户所有权限
     * @param userId 用户编号
     * @return 用户所有权限
     */
    @Select("select * from role where id in " +
            "(select roleId from users_role where userId = #{userId})")
    public List<Role> findRolesByUserId(String userId);
}
