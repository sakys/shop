package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.Article;
import com.shop.service.ArticleService;
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
public class AttributeListDirective extends BaseDirective{

    @Autowired
    private ArticleService articleService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {
        try {
            BigDecimal count = (BigDecimal) getParameter(params, "count");
            Integer articleCategoryId = (Integer) getParameter(params, "articleCategoryId");
            List<Article> articles = articleService.findArticleList(articleCategoryId, count.intValue());
            setVariable(env, body, "articles", articles);
        } catch (Exception e) {
            log.info("商品属性异常：",e);
        }
    }
}
