package com.shop.service;

import com.shop.base.ResultInfo;
import com.shop.constant.UrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IndexService {


    @Value("${app.cache.service-url}")
    private String cacheServiceUrl;

//    @Autowired
//    private RestTemplate restTemplate;

    public List<String> findHotSearchKeywords() {
        String url = cacheServiceUrl + UrlConstant.get_search_keywords_url;
//        ResponseEntity<ResultInfo> resultInfo = restTemplate.getForEntity(url, ResultInfo.class);
//        ResultInfo result = resultInfo.getBody();
       List<String> hotSearchKeywords =  null;//(List<String>) result.getResult();
        return hotSearchKeywords;
    }
}
