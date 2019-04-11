package com.shop.service;

import com.shop.dao.GoodsListDao;
import com.shop.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsListService {

    @Autowired
     private GoodsListDao goodsListDao;

    public List<Goods> findGoodsList(Integer productCategoryId, int tagId, int count) {
        return goodsListDao.findGoodsList(productCategoryId,tagId,count);
    }
}
