package com.shop.service;

import com.shop.dao.PromotionListDao;
import com.shop.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PromotionListService {


    @Autowired
    private PromotionListDao promotionListDao;

    public List<Promotion> findPromotionList(Integer parentId, Boolean hasEnded, Integer count) {
        return  promotionListDao.findPromotionList(parentId,hasEnded,count);
     }
}
