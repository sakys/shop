package com.shop.service;

import com.shop.dao.NavigationDao;
import com.shop.model.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationService {

    @Autowired
    private NavigationDao navigationDao;

    public List<Navigation> findNavigations(int position) {
        return navigationDao.findNavigations(position);
    }
}
