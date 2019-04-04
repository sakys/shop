package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * Entity - 广告位
 */
@Data
public class AdPosition extends BaseModel {

	/** 名称 */
	private String name;

	/** 宽度 */
	private Integer width;

	/** 高度 */
	private Integer height;

	/** 描述 */
	private String description;

	/** 模板 */
	private String template;
	
	/** 广告 */
	private List<Ad> ads;

}
