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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ProductCategoryRootListDirective extends BaseDirective{

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        try {
            BigDecimal count = (BigDecimal)getParameter(map,"count");
            List<ProductCategory> productCategories =  productCategoryService.findRootList(count.intValue());
            setVariable(environment,templateDirectiveBody,"productCategories",productCategories);
        } catch (Exception e) {
          log.info("获取商品根目录异常：",e);
        }
    }
}
