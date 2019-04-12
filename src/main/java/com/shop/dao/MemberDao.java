package com.shop.dao;

import com.shop.model.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select id, username, password, phone, email from tbl_member where username = #{userName} or email = #{userName}")
    Member findByUserNameOrEmail(@Param("userName") String userName);
}
