package com.shop.model;

import java.math.BigDecimal;
import java.util.Date;

import com.shop.base.BaseModel;
import lombok.Data;

/**
 * Entity - 订单
 */
@Data
public class Order extends BaseModel {


    /**
     * 锁定过期时间
     */
    public static final int LOCK_EXPIRE = 60;

    /**
     * 编号
     */
    private String sn;

    /**
     * 类型
     */
    private int type;

    /**
     * 状态
     */
    private int status;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 支付手续费
     */
    private BigDecimal fee;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 税金
     */
    private BigDecimal tax;

    /**
     * 促销折扣
     */
    private BigDecimal promotionDiscount;

    /**
     * 优惠券折扣
     */
    private BigDecimal couponDiscount;

    /**
     * 调整金额
     */
    private BigDecimal offsetAmount;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 已付金额
     */
    private BigDecimal amountPaid;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 赠送积分
     */
    private Long rewardPoint;

    /**
     * 兑换积分
     */
    private Long exchangePoint;

    /**
     * 商品重量
     */
    private Integer weight;

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
     * 收货人
     */
    private String consignee;

    /**
     * 地区名称
     */
    private String areaName;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 电话
     */
    private String phone;

    /**
     * 附言
     */
    private String memo;

    /**
     * 过期时间
     */
    private Date expire;

    /**
     * 是否已使用优惠码
     */
    private Boolean isUseCouponCode;

    /**
     * 是否已兑换积分
     */
    private Boolean isExchangePoint;

    /**
     * 是否已分配库存
     */
    private Boolean isAllocatedStock;

    /**
     * 支付方式名称
     */
    private String paymentMethodName;

    private Integer shippingMethod;

    /**
     * 配送方式名称
     */
    private String shippingMethodName;

    /**
     * 锁定KEY
     */
    private String lockKey;

    /**
     * 锁定过期时间
     */
    private Date lockExpire;

    /**
     * 完成日期
     */
    private Date completeDate;

    /**
     * 地区
     */
    private Integer area;

    /**
     * 会员
     */
    private Integer member;

    /**
     * 发票内容
     */
    private String invoiceContent;
    private String invoiceTitle;
    private Integer paymentMethodType;
    private Integer paymentMethod;
    private String promotionNames;
    private String couponCode;

}
