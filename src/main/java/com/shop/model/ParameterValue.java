package com.shop.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity - 参数值
 */
@Data
public class ParameterValue implements Serializable {

	private static final long serialVersionUID = 6528715812286491634L;

	/** 参数组 */
	private String group;

	/** 条目 */
	private List<Entry> entries = new ArrayList<Entry>();

}
