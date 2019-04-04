package com.shop.model;

import com.shop.base.BaseModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * Entity - 地区
 * 
 */
@Data
public class Area extends BaseModel {

	/** 树路径分隔符 */
	public static final String TREE_PATH_SEPARATOR = ",";

	/** 名称 */
	private String name;

	/** 全称 */
	private String fullName;

	/** 树路径 */
	private String treePath;

	/** 层级 */
	private Integer grade;

	/** 上级地区 */
	private Area parent;

	/** 下级地区 */
	private List<Area> children = new ArrayList<>();

}
