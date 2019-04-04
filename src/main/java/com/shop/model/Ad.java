package com.shop.model;

import com.shop.base.BaseModel;
import com.shop.constant.TypeEnum;
import lombok.Data;

import java.beans.Transient;
import java.util.Date;

@Data
public class Ad extends BaseModel {
	
	private Integer orders;
	/** 标题 */
	private String title;

	/** 类型 0=文本 1=图片*/
	private TypeEnum type;

	/** 内容 */
	private String content;

	/** 路径 */
	private String path;

	/** 起始日期 */
	private Date beginDate;

	/** 结束日期 */
	private Date endDate;

	/** 链接地址 */
	private String url;
	
	private Integer adPosition;

	/**
	 * 判断是否已开始
	 * 
	 * @return 是否已开始
	 */
	@Transient
	public boolean hasBegun() {
		return getBeginDate() == null || !getBeginDate().after(new Date());
	}

	/**
	 * 判断是否已结束
	 * 
	 * @return 是否已结束
	 */
	@Transient
	public boolean hasEnded() {
		return getEndDate() != null && !getEndDate().after(new Date());
	}
}