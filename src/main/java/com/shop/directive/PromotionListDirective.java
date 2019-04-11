package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.Promotion;
import com.shop.service.PromotionListService;
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
public class PromotionListDirective extends BaseDirective{

    @Autowired
    private PromotionListService promotionListService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        try {
            Integer parentId =  (Integer)getParameter(map,"productCategoryId");
            Boolean hasEnded = (Boolean) getParameter(map, "hasEnded");
            BigDecimal count = (BigDecimal)getParameter(map,"count");

            List<Promotion> promotions = promotionListService.findPromotionList(parentId,hasEnded,count.intValue());
            setVariable(environment,templateDirectiveBody,"promotions",promotions);
        } catch (Exception e) {
            log.info("热门促销异常",e);
        }
    }
}
