package com.shop.directive;

import com.shop.base.BaseDirective;
import com.shop.model.FriendLink;
import com.shop.service.FriendLinkListService;
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
public class FriendLinkListDirective extends BaseDirective {

    @Autowired
    FriendLinkListService friendLinkListService;

    @Override
    public void execute(Environment environment, Map params, TemplateModel[] templateModels
            , TemplateDirectiveBody templateDirectiveBody) {
        try {
            BigDecimal count = (BigDecimal) getParameter(params, "count");
            List<FriendLink> friendLinks = friendLinkListService.findfriendLink(count.intValue());
            setVariable(environment, templateDirectiveBody, "friendLinks", friendLinks);
        } catch (Exception e) {
            log.info("支持支付链接异常:", e);
        }
    }
}
