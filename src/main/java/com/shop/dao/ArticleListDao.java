package com.shop.dao;

import com.shop.model.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleListDao {

     @Select("SELECT id, title FROM tbl_article t where article_category = #{articleCategoryId} ORDER BY t.hits desc limit #{count}")
     List<Article> findArticleList(@Param("articleCategoryId") Integer articleCategoryId, @Param("count") int count);
}
