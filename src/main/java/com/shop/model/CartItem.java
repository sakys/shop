package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Data;

/**
 * Entity - 购物车项
 */
@Data
public class CartItem extends BaseModel {

	/** 数量 */
	private Integer quantity;

	/** 商品 */
	private Integer product;

	/** 购物车 */
	private Integer cart;
	
	private Product productInfo;

}
