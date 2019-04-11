package com.shop.config;

import com.shop.directive.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

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

    @Autowired
    private ProductCategoryRootListDirective productCategoryRootListDirective;

    @Autowired
    private  ProductCategoryChildrenListDirective productCategoryChildrenListDirective;

    @Autowired
    private  BrandListDirective brandListDirective;

    @Autowired
    private  PromotionListDirective promotionListDirective;

    @Autowired
    private  AdPositionDirective adPositionDirective;

    @Autowired
    private ArticleCategoryRootListDirective articleCategoryRootListDirective;

    @Autowired
    private  ArticleListDirective articleListDirective;

    @Autowired
    private  GoodsListDirective goodsListDirective;

    @PostConstruct // bean初始化后执行此方法
    public void setSharedVariable() throws Exception {
        configuration.setTagSyntax(configuration.AUTO_DETECT_TAG_SYNTAX);
        configuration.setSharedVariable("hello", helloDirective);
        configuration.setSharedVariable("navigation_list", navigationListDirective);
        configuration.setSharedVariable("hot_search_keywords", hotSearchKeywordsDirective);
        configuration.setSharedVariable("friend_link_list", friendLinkListDirective);
        configuration.setSharedVariable("product_category_root_list", productCategoryRootListDirective);
        configuration.setSharedVariable("product_category_children_list", productCategoryChildrenListDirective);
        configuration.setSharedVariable("brand_list",brandListDirective);
        configuration.setSharedVariable("promotion_list",promotionListDirective);
        configuration.setSharedVariable("ad_position", adPositionDirective);
        configuration.setSharedVariable("article_category_root_list",articleCategoryRootListDirective);
        configuration.setSharedVariable("article_list",articleListDirective);
        configuration.setSharedVariable("goods_list",goodsListDirective);
    }

}
