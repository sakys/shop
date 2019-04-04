/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.shop.model;

import java.math.BigDecimal;

import com.shop.base.BaseModel;
import lombok.Data;

/**
 * Entity - 订单项
 */
@Data
public class OrderItem extends BaseModel {


    /**
     * 商品编号
     */
    private String sn;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品类型
     */
    private Integer type;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品重量
     */
    private Integer weight;

    /**
     * 是否需要物流
     */
    private Boolean isDelivery;

    /**
     * 商品缩略图
     */
    private String thumbnail;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 已发货数量
     */
    private Integer shippedQuantity;

    /**
     * 已退货数量
     */
    private Integer returnedQuantity;

    /**
     * 商品
     */
    private Integer product;

    /**
     * 订单
     */
    private Integer orders;

    /**
     * 规格
     */
    private String specifications;

}
