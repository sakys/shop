package com.shop.base;

import java.io.Serializable;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import lombok.Data;

@Data
public class BaseDto implements Serializable {
	
	private int pageSize = 10; 
	private int page = 1; 
	private String sort;

	public PageBounds toPageBounds() {
		PageBounds pageBounds = new PageBounds(page, pageSize);
		if (sort != null && sort.trim().length() > 0 && sort.contains(".")) {
			pageBounds.setOrders(Order.formString(sort));
		}
		return pageBounds;
	}
}
