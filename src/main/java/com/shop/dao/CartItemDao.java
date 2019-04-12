package com.shop.dao;

import com.shop.model.CartItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CartItemDao {

    @Select("select id, quantity, cart, product, version from tbl_cart_item where cart = #{cartId} and version > -1")
    List<CartItem> findCartItems(@Param("cartId") Integer id);

    @Insert("insert into xx_cart_item (create_date,modify_date,version,quantity,cart,product) values (now(), now(), 0, #{quantity}, #{cart}, #{product})")
    void insert(CartItem cartItem);

    @Update("update tbl_cart_item set quantity = #{quantity} where id = #{id} ")
    void updateCartQuantity(@Param("quantity") Integer quantity, @Param("id") Integer id);
}
