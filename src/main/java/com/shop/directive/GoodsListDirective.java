package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.Goods;
import com.shop.service.GoodsListService;
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
public class GoodsListDirective extends BaseDirective {

    @Autowired
    private GoodsListService goodsListService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {

        // 获取参数
        Integer productCategoryId = 1;
        try {
            productCategoryId = (Integer) getParameter(params, "productCategoryId");
        } catch (Exception e) {
            BigDecimal productCategoryIdBd = (BigDecimal) getParameter(params, "productCategoryId");
            if (productCategoryIdBd != null) {
                productCategoryId = productCategoryIdBd.intValue();
            }
        }
        if (productCategoryId == null) {
            productCategoryId = 1;
        }
        BigDecimal tagId = (BigDecimal) getParameter(params, "tagId");
        BigDecimal count = (BigDecimal) getParameter(params, "count");

        // 查询数据
        List<Goods> goodsList = goodsListService.findGoodsList(productCategoryId,tagId.intValue(), count.intValue());

        // 输出数据
        try {
            setVariable(env, body, "goodsList", goodsList);
        } catch (Exception e) {
            log.info("商品列表异常：",e);
        }
    }
}
