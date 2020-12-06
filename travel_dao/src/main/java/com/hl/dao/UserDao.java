package com.hl.dao;

import com.hl.domain.Role;
import com.hl.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hl2333
 */
@Repository
public interface UserDao {

    /**
     * 根据用户id查询用户可添加的权限
     * @param id 用户id
     * @return 用户可添加的权限
     */
    @Select("select * from role where id not in " +
            "(select roleId from users_role where userId = #{id})")
    List<Role> findRoles(String id);
    /**
     * 向数据库保存用户信息
     * @param userInfo 用户信息
     */
    @Insert("INSERT INTO ssm_travel.users (email, username, password, phoneNum, status) " +
            "VALUES (#{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    public void save(UserInfo userInfo);

    @Select("select * from users")
    public List<UserInfo> findAll();
    /**
     * 根据用户名查询到用户的详细信息
     * @param username 用户名
     * @return 用户的详细信息
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",
                    javaType = java.util.List.class,
                    column = "id",
                    many = @Many(select = "com.hl.dao.RoleDao.findRolesByUserId")
            )
    })
    UserInfo findByName(String username);

    /**
     * 根据用户id查询到用户的详细信息
     * @param userId 用户id
     * @return 用户的详细信息
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",
                    javaType = java.util.List.class,
                    column = "id",
                    many = @Many(select = "com.hl.dao.RoleDao.findRolesDetailByUserId")
            )
    })
    UserInfo findById(String userId);

    /**
     * 向给用户添加角色
     * @param i 角色的id
     * @param userId 用户的id
     */
    @Insert("INSERT INTO ssm_travel.users_role " +
            "(userId, roleId) VALUES (#{param2}, #{param1})")
    void addRoles(Integer i, Integer userId);
}
