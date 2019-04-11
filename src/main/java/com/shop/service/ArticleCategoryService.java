package com.shop.service;

import com.shop.dao.ArticleCategoryDao;
import com.shop.model.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;

    public List<ArticleCategory> findList(int count) {
     return  articleCategoryDao.findList(count);
    }
}
