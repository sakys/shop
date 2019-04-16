package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.constant.GoodsOrderType;
import com.shop.model.Goods;
import com.shop.service.GoodsService;
import com.shop.vo.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/list/{productCategoryId}")
    public String list(@PathVariable Integer productCategoryId, GoodsDto goodsDto, Model model) {

        Map<String, Object> result = goodsService.list(productCategoryId, goodsDto);
        PageInfo<Goods> resultListInfo = ( PageInfo<Goods>) result.get("resultList");
        GoodsOrderType goodsOrderType = GoodsOrderType.findBySort(goodsDto.getSort());

        model.addAllAttributes(result);
        //model.addAttribute("productCategory", result.get("productCategory"));
        model.addAttribute("orderTypes", GoodsOrderType.values());
        model.addAttribute("currOrderType", goodsOrderType);

        return "goods/list";
    }

}
