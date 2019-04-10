package com.shop.dao;

import com.shop.model.FriendLink;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FriendLinkListDao {

    @Select("select id, logo, name, url from tbl_friend_link limit #{count}")
    List<FriendLink> findfriendLink(@Param("count") int count);
}
