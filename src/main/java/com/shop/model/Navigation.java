package com.shop.model;


import com.shop.base.BaseModel;
import lombok.Data;

@Data
public class Navigation extends BaseModel {
	
	private Integer orders;
	private Integer isBlankTarget;
	private String name;
	private Integer position; // 0=顶部 1=导航 2=底部
	private String url;

}
