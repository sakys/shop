package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Data;

/**
 * Entity - 友情链接
 */
@Data
public class FriendLink extends BaseModel {


	/** 名称 */
	private String name;

	/** 类型 0=文本 1=图片*/
	private int type;

	/** logo */
	private String logo;

	/** 链接地址 */
	private String url;

}
