package com.shop.dao;

import com.shop.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductCategoryDao {

    @Select("select id,name from tbl_product_category where parent is null ORDER BY orders limit #{count}")
    List<ProductCategory> findRootList(@Param("count") int count);

    @Select("SELECT id, t.`name` FROM tbl_product_category t where t.parent = #{parentId} ORDER BY orders LIMIT #{count}")
    List<ProductCategory> findChildrenList(@Param("parentId")Integer parentId, @Param("count")int limit);

    @Select("SELECT id,name,tree_path treePath,grade FROM tbl_product_category where id = #{productCategoryId}")
    ProductCategory findById(@Param("productCategoryId") Integer productCategoryId);

    @Select("SELECT id, t.`name`, tree_path treePath, grade FROM tbl_product_category t where id in (${ids})")
    List<ProductCategory> findParentCategories(@Param("ids") String treePath);
}
