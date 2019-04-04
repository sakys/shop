package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Data;

@Data
public class Attribute extends BaseModel {

    private Integer orders;
    private String name;
    private String options;
    private Integer propertyIndex;
    private Integer product_category;
    private String[] optionsList;

}
