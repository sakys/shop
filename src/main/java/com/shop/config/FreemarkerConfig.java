package com.shop.config;

import com.shop.directive.FriendLinkListDirective;
import com.shop.directive.HelloDirective;
import com.shop.directive.HotSearchKeywordsDirective;
import com.shop.directive.NavigationListDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class FreemarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private HelloDirective helloDirective;

    @Autowired
    private NavigationListDirective navigationListDirective;

    @Autowired
    private HotSearchKeywordsDirective hotSearchKeywordsDirective;

    @Autowired
    private FriendLinkListDirective friendLinkListDirective;

    @PostConstruct // bean初始化后执行此方法
    public void setSharedVariable() throws Exception {
        configuration.setTagSyntax(configuration.AUTO_DETECT_TAG_SYNTAX);
        configuration.setSharedVariable("hello", helloDirective);
        configuration.setSharedVariable("navigation_list", navigationListDirective);
        configuration.setSharedVariable("hot_search_keywords", hotSearchKeywordsDirective);
        configuration.setSharedVariable("friend_link_list", friendLinkListDirective);
    }

}
