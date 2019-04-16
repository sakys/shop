package com.shop.service;

import com.shop.constant.ProductCategoryGrade;
import com.shop.dao.ProductCategoryDao;
import com.shop.exception.ParamException;
import com.shop.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    public List<ProductCategory> findRootList(int count) {
        return productCategoryDao.findRootList(count);
    }

    public List<ProductCategory> findChildrenList(Integer parentId, int limit, Boolean recursive) {
        if (parentId == null) {
            throw new ParamException("请输入类别ID");
        }
        if (recursive == null) {
            throw new ParamException("请选择查询的类型");
        }
        List<ProductCategory> productCategories = null;
        if (!recursive) { // 只查询出子类
            productCategories = productCategoryDao.findChildrenList(parentId, limit);
        } else {

        }
     return productCategories;
    }

    public ProductCategory findById(Integer productCategoryId) {
        return  productCategoryDao.findById(productCategoryId);
    }

    public List<ProductCategory> findParentList(Integer productCategoryId) {
        ProductCategory productCategory = findById(productCategoryId);
        if (productCategory.getGrade() == ProductCategoryGrade.ROOT.getGrade()) { // 如果是根级就不需要查询父级
            return Collections.emptyList();
        }
        // 获取parentIds
        String treePath = productCategory.getTreePath();
        treePath = treePath.substring(treePath.indexOf(",") + 1, treePath.lastIndexOf(","));
        List<ProductCategory> productCategories = new ArrayList<>();
        if (productCategory.getGrade() == ProductCategoryGrade.SECOND.getGrade()) { // 如果是第二级的话就单个查询
            ProductCategory parentProductCategory = findById(Integer.parseInt(treePath));
            productCategories.add(parentProductCategory);
        } else {
            productCategories = productCategoryDao.findParentCategories(treePath);
        }
        return  productCategories;
    }
}
