package com.shop.service;

import com.shop.dao.ArticleListDao;
import com.shop.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleListService {


    @Autowired
    private ArticleListDao articleListDao;

    public List<Article> findArticleList(Integer articleCategoryId, int count) {
     return  articleListDao.findArticleList(articleCategoryId,count);
    }
}
