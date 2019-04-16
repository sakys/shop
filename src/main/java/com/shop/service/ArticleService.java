package com.shop.service;

import com.shop.dao.ArticleDao;
import com.shop.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public List<Article> findArticleList(Integer articleCategoryId, int count) {
     return  articleDao.findArticleList(articleCategoryId,count);
    }
}
