package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.service.IndexService;
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
public class HotSearchKeywordsDirective extends BaseDirective {

    @Autowired
    private IndexService indexService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) {
        try {
            List<String> hotkeys = indexService.findHotSearchKeywords();
            setVariable(environment, templateDirectiveBody, "hotkeys", hotkeys);
        } catch (Exception e) {
            log.info("热门搜索异常：", e);
        }
    }
}
