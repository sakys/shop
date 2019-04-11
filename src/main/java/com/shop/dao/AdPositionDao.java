package com.shop.dao;

import com.shop.model.AdPosition;
import org.apache.ibatis.annotations.Select;

public interface AdPositionDao {

    AdPosition findById(int id);

}
