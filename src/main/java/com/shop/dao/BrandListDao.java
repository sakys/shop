package com.shop.dao;

import com.shop.model.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface BrandListDao {
    @Select("SELECT id, name, logo FROM tbl_brand b LEFT JOIN tbl_product_category_brand cb on cb.brands=b.id WHERE cb.product_categories=#{productCategoryId}"
            + " ORDER BY orders LIMIT #{count}")
    List<Brand> findBrandList(@Param("productCategoryId") Integer productCategoryId, @Param("count") Integer count);

    @Select("SELECT id, name, logo FROM tbl_brand WHERE type=#{type} ORDER BY orders LIMIT #{count}")
    List<Brand> findBrandListByType(@Param("type") int type, @Param("count") Integer count);
}
