package com.shop.service;

import com.shop.dao.AdPositionDao;
import com.shop.model.AdPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdPositionService {


    @Autowired
    private AdPositionDao adPositionDao;

    public AdPosition findById(int id) {
        return  adPositionDao.findById(id);
    }
}
