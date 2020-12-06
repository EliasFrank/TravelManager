package com.hl.dao;

import com.hl.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author hl2333
 */
@Repository
public interface MemberDao {

    /**
     * 根据成员编号查看成员的详细信息
     * @param id 成员编号
     * @return 成员的详细信息
     */
    @Select("select * from member where id = #{id}")
    Member findById(int id);
}
