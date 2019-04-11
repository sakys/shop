package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.ProductCategory;
import com.shop.service.ProductCategoryService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ProductCategoryChildrenListDirective extends BaseDirective{

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void execute(Environment environment, Map params, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody){
        try {
            Integer parentId =  (Integer)getParameter(params,"productCategoryId");
            BigDecimal count = (BigDecimal) getParameter(params, "count");
            Boolean recursive = (Boolean) getParameter(params, "recursive"); // 是否递归查询

            int limit = 0;
            if(count != null){
                limit = count.intValue();
            }
            // 查询根节点的商品类别
            List<ProductCategory> productCategories = productCategoryService.findChildrenList(parentId,limit,recursive);
            setVariable(environment,templateDirectiveBody,"productCategories",productCategories);
        } catch (Exception e) {
            log.info("根节点的商品类别异常:",e);
        }
    }
}
