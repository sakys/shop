package com.shop.dao;

import com.shop.model.Promotion;
import com.shop.sqlProvider.PromotionProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.math.BigDecimal;
import java.util.List;

public interface PromotionListDao {

    @SelectProvider(type = PromotionProvider.class,method = "findProPromotionList")
    List<Promotion> findPromotionList(@Param("parentId") Integer parentId, @Param("hasEnded") Boolean hasEnded, @Param("count") Integer count);
}
