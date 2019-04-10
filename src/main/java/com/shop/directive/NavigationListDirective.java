package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
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
public class NavigationListDirective extends BaseDirective {

    @Autowired
    private NavigationService navigationService;

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody)
            throws TemplateException, IOException {
        try {
            BigDecimal position = (BigDecimal) getParameter(map, "position");
            List<Navigation> navigations = navigationService.findNavigations(position.intValue());
            setVariable(environment, templateDirectiveBody, "navigationList", navigations);
        } catch (Exception e) {
            log.info("导航异常：",e);
        }
    }
}
