package com.hl.dao;

import com.hl.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hl2333
 */
public interface UserDao {

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
}
