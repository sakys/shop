package com.shop.util;

import com.shop.base.BaseDto;
import com.shop.base.ResultListInfo;
import com.shop.vo.PageInfo;
import org.springframework.beans.BeanUtils;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

public class ResultListUtil<E> {
	
	/**
	 * 构建分页结果集
	 * @param baseDto
	 * @param result
	 * @return
	 */
	public ResultListInfo<E> buildResultList(BaseDto baseDto, PageList<E> result) {
		ResultListInfo<E> resultListInfo = new ResultListInfo<>();
		resultListInfo.setBaseDto(baseDto);
		resultListInfo.setResults(result);
		PageInfo pageInfo = new PageInfo();
		Paginator paginator = result.getPaginator();
		BeanUtils.copyProperties(paginator, pageInfo);
		resultListInfo.setPageInfo(pageInfo);
		return resultListInfo;
	}
}
