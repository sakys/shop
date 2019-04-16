package com.shop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.constant.ProductCategoryGrade;
import com.shop.dao.GoodsListDao;
import com.shop.model.Goods;
import com.shop.model.ProductCategory;
import com.shop.util.AssertUtil;
import com.shop.vo.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {


    @Autowired
    private GoodsListDao goodsListDao;


    @Autowired
    private ProductCategoryService productCategoryService;


    public Map<String, Object> list(Integer productCategoryId, GoodsDto goodsDto) {

        AssertUtil.isTrue(productCategoryId == null || productCategoryId < 1, "请选择一个分类");

        // 获取分类信息
        ProductCategory productCategory = productCategoryService.findById(productCategoryId);

        // 组装treepath: 父级 + "," + productCategoryId
        String treepath = "";
        if (productCategory.getGrade() != ProductCategoryGrade.ROOT.getGrade()) {
            treepath = productCategory.getTreePath() + productCategoryId;
        } else {
            treepath = "," + productCategoryId;
        }
        treepath = treepath + ",";
        goodsDto.setTreePath(treepath);
        goodsDto.setProductCategoryId(productCategoryId);
      //  PageList<Goods> goodsList = (PageList<Goods>)goodsListDao.list(goodsDto); //(PageList<Goods>)PageList
        PageHelper.startPage(goodsDto.getPage(), goodsDto.getPageSize(), true);
        List<Goods> goodsList = goodsListDao.list(goodsDto);
        PageInfo<Goods> resultListInfo = new PageInfo<Goods>(goodsList);

       // ResultListInfo<Goods> resultListInfo = initResultList(goodsDto, goodsList);
        Map<String, Object> result = new HashMap<>();
        result.put("productCategory", productCategory);
        result.put("resultList", resultListInfo);
        return result;
    }

//    private ResultListInfo<Goods> initResultList(GoodsDto goodsDto, PageList<Goods> goodsList) {
//
//        ResultListInfo<Goods> resultListInfo = new ResultListInfo<Goods>();
//        resultListInfo.setBaseDto(goodsDto);
//        resultListInfo.setResults(goodsList);
//        PageInfo pageInfo = new PageInfo();
//        Paginator paginator = goodsList.getPaginator();
//        BeanUtils.copyProperties(paginator, pageInfo);
//        resultListInfo.setPageInfo(pageInfo);
//
//        return resultListInfo;
//    }
}
