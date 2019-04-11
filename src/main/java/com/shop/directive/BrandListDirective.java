package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.Brand;
import com.shop.service.BrandListService;
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
public class BrandListDirective extends BaseDirective{

    @Autowired
    private BrandListService brandListService;

    @Override
    public void execute(Environment environment, Map params, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {


        try {
            Integer productCategoryId = (Integer)getParameter(params,"productCategoryId");
            BigDecimal count = (BigDecimal) getParameter(params, "count");
            BigDecimal type = (BigDecimal) getParameter(params, "type");
            List<Brand> brands  = brandListService.findBrandList(productCategoryId,count.intValue(),type);
            setVariable(environment,templateDirectiveBody,"brands",brands);
        } catch (Exception e) {
          log.info("品牌异常：",e);
        }
    }
}
