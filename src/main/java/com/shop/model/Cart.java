package com.shop.model;

import java.util.Date;

import com.shop.base.BaseModel;
import lombok.Data;

/**
 * Entity - 购物车
 */
@Data
public class Cart extends BaseModel {


	public static final int TIMEOUT = 604800;

	/** 密钥 */
	private String cartKey;

	/** 过期时间 */
	private Date expire;

	/** 会员 */
	private Integer member;

}
