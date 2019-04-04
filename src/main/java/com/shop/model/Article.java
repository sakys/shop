package com.shop.model;


import com.shop.base.BaseModel;
import lombok.Data;

/**
 * Entity - 文章
 */
@Data
public class Article extends BaseModel {

	/** 标题 */
	private String title;

	/** 作者 */
	private String author;

	/** 内容 */
	private String content;

	/** 页面标题 */
	private String seoTitle;

	/** 页面关键词 */
	private String seoKeywords;

	/** 页面描述 */
	private String seoDescription;

	/** 是否发布 */
	private Boolean isPublication;

	/** 是否置顶 */
	private Boolean isTop;

	/** 点击数 */
	private Long hits;

	/** 静态生成方式 */
	private int generateMethod; // 0=无 1=及时 2=延迟

	/** 文章分类 */
	private Integer articleCategory;

}
