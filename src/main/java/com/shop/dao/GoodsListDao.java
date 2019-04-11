package com.shop.dao;

import com.shop.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsListDao {

    @Select("SELECT g.id, g.`name`, g.caption, g.price, g.market_price, g.image FROM tbl_goods g LEFT JOIN tbl_product_category p on g.product_category=p.id "
            + "LEFT JOIN tbl_goods_tag t on g.id=t.goods where p.tree_path LIKE ',${productCategoryId}%' "
            + "and t.tags=#{tagId} LIMIT #{count}")
    List<Goods> findGoodsList(@Param("productCategoryId") Integer productCategoryId, @Param("tagId") int tagId, @Param("count") int count);
}
