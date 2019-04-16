package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.ProductCategory;
import com.shop.service.ProductCategoryService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ProductCategoryParentListDirective extends BaseDirective{

    @Autowired
    private ProductCategoryService productCategoryService;


    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        try {
            // 获取参数
            Integer productCategoryId = (Integer) getParameter(map, "productCategoryId");
            // 查询根节点的商品类别
            List<ProductCategory> productCategories = productCategoryService.findParentList(productCategoryId);
            // 把数据进行输出
            setVariable(environment, templateDirectiveBody, "productCategories", productCategories);
        } catch (Exception e) {
          log.info("查找商品分类异常：",e);
        }

    }
}
