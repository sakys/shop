package com.shop.service;

import com.shop.constant.ProductCategoryGrade;
import com.shop.dao.BrandListDao;
import com.shop.model.Brand;
import com.shop.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BrandListService {

    @Autowired
    private BrandListDao brandListDao;

    @Autowired
    private ProductCategoryService productCategoryService;

    public List<Brand> findBrandList(Integer productCategoryId, Integer count, BigDecimal type) {

        if (null == productCategoryId) {
            return brandListDao.findBrandListByType(type.intValue(), count);
        }
        ProductCategory category = productCategoryService.findById(productCategoryId);

        if (category.getGrade() != ProductCategoryGrade.ROOT.getGrade()) {
            String treePath = category.getTreePath();
            String rootId = treePath.split(",")[1];
            productCategoryId = Integer.parseInt(rootId);
        }
        return brandListDao.findBrandList(productCategoryId, count);
    }
}
