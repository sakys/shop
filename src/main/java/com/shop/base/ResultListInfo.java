package com.shop.base;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResultListInfo<E> implements Serializable {

    private BaseDto baseDto; // 回显
    private List<E> results; // 数据
  //  private PageInfo pageInfo; // 分页对象

}
