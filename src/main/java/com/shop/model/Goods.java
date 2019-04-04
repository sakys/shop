package com.shop.model;

import java.math.BigDecimal;
import java.util.Date;

import com.shop.base.BaseModel;
import lombok.Data;

/**
 * Entity - 货品
 */
@Data
public class Goods extends BaseModel {

	/** 编号 */
	private String sn;

	/** 名称 */
	private String name;

	/** 副标题 */
	private String caption;

	/** 类型 */
	private int type;

	/** 销售价 */
	private BigDecimal price;

	/** 市场价 */
	private BigDecimal marketPrice;

	/** 展示图片 */
	private String image;

	/** 单位 */
	private String unit;

	/** 重量 */
	private Integer weight;

	/** 是否上架 */
	private Boolean isMarketable;

	/** 是否列出 */
	private Boolean isList;

	/** 是否置顶 */
	private Boolean isTop;

	/** 是否需要物流 */
	private Boolean isDelivery;

	/** 介绍 */
	private String introduction;

	/** 备注 */
	private String memo;

	/** 搜索关键词 */
	private String keyword;

	/** 页面标题 */
	private String seoTitle;

	/** 页面关键词 */
	private String seoKeywords;

	/** 页面描述 */
	private String seoDescription;

	/** 评分 */
	private Float score;

	/** 总评分 */
	private Long totalScore;

	/** 评分数 */
	private Long scoreCount;

	/** 周点击数 */
	private Long weekHits;

	/** 月点击数 */
	private Long monthHits;

	/** 点击数 */
	private Long hits;

	/** 周销量 */
	private Long weekSales;

	/** 月销量 */
	private Long monthSales;

	/** 销量 */
	private Long sales;

	/** 周点击数更新日期 */
	private Date weekHitsDate;

	/** 月点击数更新日期 */
	private Date monthHitsDate;

	/** 周销量更新日期 */
	private Date weekSalesDate;

	/** 月销量更新日期 */
	private Date monthSalesDate;

	/** 静态生成方式 */
	private int generateMethod;

	/** 属性值0 */
	private String attributeValue0;

	/** 属性值1 */
	private String attributeValue1;

	/** 属性值2 */
	private String attributeValue2;

	/** 属性值3 */
	private String attributeValue3;

	/** 属性值4 */
	private String attributeValue4;

	/** 属性值5 */
	private String attributeValue5;

	/** 属性值6 */
	private String attributeValue6;

	/** 属性值7 */
	private String attributeValue7;

	/** 属性值8 */
	private String attributeValue8;

	/** 属性值9 */
	private String attributeValue9;

	/** 属性值10 */
	private String attributeValue10;

	/** 属性值11 */
	private String attributeValue11;

	/** 属性值12 */
	private String attributeValue12;

	/** 属性值13 */
	private String attributeValue13;

	/** 属性值14 */
	private String attributeValue14;

	/** 属性值15 */
	private String attributeValue15;

	/** 属性值16 */
	private String attributeValue16;

	/** 属性值17 */
	private String attributeValue17;

	/** 属性值18 */
	private String attributeValue18;

	/** 属性值19 */
	private String attributeValue19;

	/** 商品分类 */
	private Integer productCategory;

	/** 品牌 */
	private Integer brand;

	/** 商品图片 */
	private String productImages;

	/** 参数值 */
	private String parameterValues;

	/** 规格项 */
	private String specificationItems;

}
