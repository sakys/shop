package com.shop.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Entity - 条目
 */
@Data
public class Entry implements Serializable {

	private static final long serialVersionUID = 2507799432135866022L;
	
	/** 名称 */
	private String name;
	/** 值 */
	private String value;

}