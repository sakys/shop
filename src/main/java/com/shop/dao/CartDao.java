package com.shop.dao;

import com.shop.model.Cart;
import org.apache.ibatis.annotations.*;

public interface CartDao {

    @Select("select id, expire, cart_key, member from tbl_cart where member = #{memberId}")
    Cart findByMemberId(@Param("memberId") Integer memberId);

    @Insert("INSERT INTO tbl_cart (create_date, modify_date, version, expire, cart_key, member) VALUES(#{createDate},#{modifyDate},#{version},#{expire},#{cartKey},#{member})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Cart cart);

    @Select("select id, expire, cart_key, member from tbl_cart where cart_key = #{cartKey}")
    Cart findByCartKey(@Param("cartKey") String cartKey);

    @Update("update tbl_cart set member = #{memberId} where id = #{id}")
    void updateMember(@Param("id") Integer id, @Param("memberId") Integer memberId);
}
