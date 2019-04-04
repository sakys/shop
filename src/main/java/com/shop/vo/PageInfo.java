package com.shop.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageInfo implements Serializable {

    private int page; // 当面页码
    private int limit; // 分页条数
    private int totalCount; // 总数
    private int totalPages; // 总页数
    private boolean firstPage; // 是否首页
    private boolean lastPage; // 是否尾页
    private boolean hasNextPage; // 是否有下一页
    private boolean hasPrePage; // 是否有上一页
    private Integer[] slider; // 中间页码

}
