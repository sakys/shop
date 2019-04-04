package com.shop.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseModel implements Serializable {

    private Integer id;
    private Date createDate;
    private Date modifyDate;
    private Integer version;

}
