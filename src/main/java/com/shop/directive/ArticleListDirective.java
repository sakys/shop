package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.Article;
import com.shop.service.ArticleListService;
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
public class ArticleListDirective extends BaseDirective{

    @Autowired
    private ArticleListService articleListService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {

        try {
            Integer articleCategoryId = (Integer) getParameter(map, "articleCategoryId");
            BigDecimal count = (BigDecimal) getParameter(map, "count");
            List<Article> articles = articleListService.findArticleList(articleCategoryId, count.intValue());
            setVariable(environment, templateDirectiveBody, "articles", articles);
        } catch (Exception e) {
            log.info("文章异常：",e);
        }
    }
}
