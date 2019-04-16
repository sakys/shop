package com.shop.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.shop.base.BaseDto;
import lombok.Data;

@Data
public class GoodsDto extends BaseDto  implements Serializable {
	
	private String keyword;
	private BigDecimal startPrice;
	private BigDecimal endPrice;
	private Integer productCategoryId;
	private String treePath;
	private Integer brandId;
	private String attributeValue0;
	private String attributeValue1;
	private String attributeValue2;
	private String attributeValue3;

}
