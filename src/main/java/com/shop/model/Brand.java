package com.shop.model;


import com.shop.base.BaseModel;
import lombok.Data;

@Data
public class Brand extends BaseModel {
	
	private Integer orders;
	private String introduction; // 介绍
	private String logo; // logo
	private String name; // 品牌名称
	private Integer type; // 0=文本 1=图片
	private String url; // 网址

}
