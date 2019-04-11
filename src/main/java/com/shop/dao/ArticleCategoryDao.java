package com.shop.dao;

import com.shop.model.ArticleCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleCategoryDao {

    @Select("SELECT id, `name` FROM tbl_article_category ORDER BY orders limit #{count}")
    List<ArticleCategory> findList(@Param("count")int count);
}
