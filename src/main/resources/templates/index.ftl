<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="${ctx}/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="${ctx}/slider/slider.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.tools.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.lazyload.js"></script>
    <script type="text/javascript" src="${ctx}/slider/slider.js"></script>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <title>商城主页</title>
</head>
<body>

    [#include "include/header.ftl"]

    <div class="container index">
        <div class="row">
            <div class="span2">
            [@product_category_root_list count = 6]
                <div id="productCategoryMenu" class="productCategoryMenu">
                    <ul>
                        [#list productCategories as productCategory]
                            <li>
                                [@product_category_children_list productCategoryId = productCategory.id recursive = false count = 3]
                                    <div class="item[#if !productCategory_has_next] last[/#if]">
                                        <div>
                                            [#list productCategories as productCategory]
                                                <a href="${ctx}${productCategory.path}">
                                                    <strong>${productCategory.name}</strong>
                                                </a>
                                            [/#list]
                                        </div>
                                        <div>
                                            [@brand_list productCategoryId = productCategory.id count = 4]
                                                [#list brands as brand]
                                                    <a href="${ctx}${brand.path}">${brand.name}</a>
                                                [/#list]
                                            [/@brand_list]
                                        </div>
                                    </div>
                                [/@product_category_children_list]
                                [@product_category_children_list productCategoryId = productCategory.id recursive = false count = 8]
                                    <div class="menu">
                                        [#list productCategories as productCategory]
                                            <dl class="clearfix[#if !productCategory_has_next] last[/#if]">
                                                <dt>
                                                    <a href="${ctx}${productCategory.path}">${productCategory.name}</a>
                                                </dt>
                                                [@product_category_children_list productCategoryId = productCategory.id recursive = false count = 100]
                                                    [#list productCategories as productCategory]
                                                        <dd>
                                                            <a href="${ctx}${productCategory.path}">${productCategory.name}</a>[#if productCategory_has_next]|[/#if]
                                                        </dd>
                                                    [/#list]
                                                [/@product_category_children_list]
                                            </dl>
                                        [/#list]
                                        <div class="auxiliary">
                                            [@brand_list productCategoryId = productCategory.id count = 8]
                                                [#if brands?has_content]
                                                    <div>
                                                        <strong>推荐品牌</strong>
                                                        [#list brands as brand]
                                                            <a href="${ctx}${brand.path}">${brand.name}</a>
                                                        [/#list]
                                                    </div>
                                                [/#if]
                                            [/@brand_list]
                                            [@promotion_list productCategoryId = productCategory.id hasEnded = false count = 4]
                                                [#if promotions?has_content]
                                                    <div>
                                                        <strong>热门促销</strong>
                                                        [#list promotions as promotion]
                                                            [#if promotion.image?has_content]
                                                                <a href="${ctx}${promotion.path}" title="${promotion.title}">
                                                                    <img src="${promotion.image}" alt="${promotion.title}" />
                                                                </a>
                                                            [/#if]
                                                        [/#list]
                                                    </div>
                                                [/#if]
                                            [/@promotion_list]
                                        </div>
                                    </div>
                                [/@product_category_children_list]
                            </li>
                        [/#list]
                    </ul>
                </div>
            [/@product_category_root_list]
            </div>
            <div class="span10">
             [@ad_position id = 1 /]
            </div>
        </div>
        [#--<div class="row">--]
            [#--<div class="span9">--]
            [#--[@ad_position id = 2 /]--]
            [#--</div>--]
            [#--<div class="span3">--]
            [#--[@article_category_root_list count = 2]--]
                [#--[#if articleCategories?has_content]--]
                    [#--<div id="newArticle" class="newArticle">--]
                        [#--<ul class="tab">--]
                            [#--[#list articleCategories as articleCategory]--]
                                [#--<li>--]
                                    [#--<a href="${ctx}${articleCategory.path}" target="_blank">${articleCategory.name}</a>--]
                                [#--</li>--]
                            [#--[/#list]--]
                        [#--</ul>--]
                        [#--[#list articleCategories as articleCategory]--]
                            [#--[@article_list articleCategoryId = articleCategory.id count = 6]--]
                                [#--<ul class="tabContent[#if articleCategory_index > 0] hidden[/#if]">--]
                                    [#--[#list articles as article]--]
                                        [#--<li>--]
                                            [#--<a href="${article.url}" title="${article.title}" target="_blank">${article.title}</a>--]
                                        [#--</li>--]
                                    [#--[/#list]--]
                                [#--</ul>--]
                            [#--[/@article_list]--]
                        [#--[/#list]--]
                    [#--</div>--]
                [#--[/#if]--]
            [#--[/@article_category_root_list]--]
            [#--</div>--]
        [#--</div>--]
        [#--<div class="row">--]
            [#--<div class="span12">--]
            [#--[@ad_position id = 3 /]--]
            [#--</div>--]
        [#--</div>--]
    [#--[@product_category_root_list count = 3]--]
        [#--[@ad_position id = 4]--]
            [#--[#if adPosition??]--]
                [#--[#assign adIterator = adPosition.ads.iterator() /]--]
            [#--[/#if]--]
        [#--[/@ad_position]--]
        [#--[#list productCategories as productCategory]--]
            [#--[@goods_list productCategoryId = productCategory.id tagId = 3 count = 10]--]
                [#--<div class="row">--]
                    [#--<div class="span12">--]
                        [#--<div class="hotGoods">--]
                            [#--[@product_category_children_list productCategoryId = productCategory.id recursive = false count = 8]--]
                                [#--<dl class="title${productCategory_index + 1}">--]
                                    [#--<dt>--]
                                        [#--<a href="${ctx}${productCategory.path}">${productCategory.name}</a>--]
                                    [#--</dt>--]
                                    [#--[#list productCategories as productCategory]--]
                                        [#--<dd>--]
                                            [#--<a href="${ctx}${productCategory.path}">${productCategory.name}</a>--]
                                        [#--</dd>--]
                                    [#--[/#list]--]
                                [#--</dl>--]
                            [#--[/@product_category_children_list]--]
                            [#--<div>--]
                                [#--[#if adIterator?? && adIterator.hasNext()]--]
                                    [#--[#assign ad = adIterator.next() /]--]
                                    [#--[#if ad.url??]--]
                                        [#--<a href="${ad.url}">--]
                                            [#--<img src="${ad.path}" alt="${ad.title}" title="${ad.title}" />--]
                                        [#--</a>--]
                                    [#--[#else]--]
                                        [#--<img src="${ad.path}" alt="${ad.title}" title="${ad.title}" />--]
                                    [#--[/#if]--]
                                [#--[/#if]--]
                            [#--</div>--]
                            [#--<ul>--]
                                [#--[#list goodsList as goods]--]
                                    [#--[#if goods_index < 5]--]
                                        [#--<li>--]
                                            [#--<a href="${goods.url}" title="${goods.name}" target="_blank">--]
                                                [#--<div>--]
                                                    [#--[#if goods.caption?has_content]--]
                                                        [#--<span title="${goods.name}">${goods.name}</span>--]
                                                        [#--<em title="${goods.caption}">${goods.caption}</em>--]
                                                    [#--[#else]--]
                                                    [#--${goods.name}--]
                                                    [#--[/#if]--]
                                                [#--</div>--]
                                                [#--<strong>${goods.price}</strong>--]
                                                [#--<img src="${ctx}/upload/image/blank.gif" data-original="${goods.image?if_exists}" />--]
                                            [#--</a>--]
                                        [#--</li>--]
                                    [#--[#else]--]
                                        [#--<li class="low">--]
                                            [#--<a href="${goods.url}" title="${goods.name}" target="_blank">--]
                                                [#--<img src="${ctx}/upload/image/blank.gif" data-original="${goods.image}" />--]
                                                [#--<span title="${goods.name}">${goods.name}</span>--]
                                                [#--<strong>${goods.price}</strong>--]
                                            [#--</a>--]
                                        [#--</li>--]
                                    [#--[/#if]--]
                                [#--[/#list]--]
                            [#--</ul>--]
                        [#--</div>--]
                    [#--</div>--]
                [#--</div>--]
            [#--[/@goods_list]--]
        [#--[/#list]--]
    [#--[/@product_category_root_list]--]

        [#--<div class="row">--]
            [#--<div class="span12">--]
            [#--[@ad_position id = 5 /]--]
            [#--</div>--]
        [#--</div>--]


        [#--<div class="row">--]
            [#--<div class="span12">--]
            [#--[@brand_list type = 1 count = 10]--]
                [#--[#if brands?has_content]--]
                    [#--<div class="hotBrand">--]
                        [#--<ul class="clearfix">--]
                            [#--[#list brands as brand]--]
                                [#--<li>--]
                                    [#--<a href="${ctx}${brand.path}" title="${brand.name}">--]
                                        [#--<img src="${brand.logo}" alt="${brand.name}" />--]
                                    [#--</a>--]
                                [#--</li>--]
                            [#--[/#list]--]
                        [#--</ul>--]
                    [#--</div>--]
                [#--[/#if]--]
            [#--[/@brand_list]--]
            [#--</div>--]
        [#--</div>--]


    </div>



    [#include  "include/footer.ftl"]
</body>
</html>