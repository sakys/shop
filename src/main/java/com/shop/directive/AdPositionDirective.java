package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.AdPosition;
import com.shop.service.AdPositionService;
import freemarker.core.Environment;
import freemarker.template.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class AdPositionDirective extends BaseDirective {

    @Autowired
    private AdPositionService adPositionService;

    @Autowired
    private Configuration configuration;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {

        BigDecimal positionId = (BigDecimal) getParameter(params, "id");
        AdPosition adPosition = adPositionService.findById(positionId.intValue());

        if (null != adPosition && StringUtils.isNotBlank(adPosition.getTemplate())) {
            if (null != body) {
                try {
                    setVariable(env, body, "adPosition", adPosition);
                } catch (Exception e) {
                    log.info("活动页面异常", e);
                }
                return;
            }
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("adPosition", adPosition);
            Writer writer = env.getOut();
            Template template = new Template("adTemplate", new StringReader(adPosition.getTemplate()), configuration);
            template.process(template, writer);
        }
    }
}
