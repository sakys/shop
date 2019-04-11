package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.ArticleCategory;
import com.shop.service.ArticleCategoryService;
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
public class ArticleCategoryRootListDirective extends BaseDirective{

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        try {
            BigDecimal count = (BigDecimal) getParameter(map, "count");
            List<ArticleCategory> articleCategories = articleCategoryService.findList(count.intValue());
            setVariable(environment, templateDirectiveBody, "articleCategories", articleCategories);
        } catch (Exception e) {
           log.info("文章分类异常",e);
        }

    }
}
