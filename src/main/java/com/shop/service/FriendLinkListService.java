package com.shop.service;

import com.shop.dao.FriendLinkListDao;
import com.shop.model.FriendLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendLinkListService {

    @Autowired
    private FriendLinkListDao friendLinkListDao;

    public List<FriendLink> findfriendLink(int count) {
      return  friendLinkListDao.findfriendLink(count);
    }
}
