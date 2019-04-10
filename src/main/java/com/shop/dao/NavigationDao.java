package com.shop.dao;

import com.shop.model.Navigation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NavigationDao {

    @Select("select id,name,url,is_blank_target isBlankTarget from tbl_navigation where position = #{position} order by orders")
    List<Navigation> findNavigations( @Param("position") int position);

}
