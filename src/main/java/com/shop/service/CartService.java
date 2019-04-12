package com.shop.service;

import com.shop.dao.CartDao;
import com.shop.dao.CartItemDao;
import com.shop.model.Cart;
import com.shop.model.CartItem;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {


    @Autowired
    private CartDao cartDao;

    @Autowired
    private CartItemDao cartItemDao;


    public String syncCart(Integer memberId, String cartKey) {

        if(StringUtils.isNotBlank(cartKey)){
            return  null;
        }
        // 获取用户的购物车
        Cart memberCart = cartDao.findByMemberId(memberId);
        if (memberCart == null) { // 如果这个用户没有购物车信息
            return syncCartInResgiter(memberId, cartKey);
        }

        if (memberCart.getCartKey().equals(cartKey)) { // 这里就是用户的购物车和浏览器的购物车是一致
            return null;
        }

        // 用户购物车和浏览器的cartKey购物车不一致时
        // 先获取到cart的购物车信息
        Cart cartKeyCart = cartDao.findByCartKey(cartKey);
        if(cartKeyCart == null){
            return  null;
        }
        // 获取memberCart的商品以及cartKeyCart的商品
        List<CartItem> cartKeyCartItems = cartItemDao.findCartItems(cartKeyCart.getId());
        if (cartKeyCartItems.isEmpty()) { // 如果carKey里面没有商品就返回用户购物车的cartKey 到时更新cookie中的cartKey
            // 不需要同步
            return memberCart.getCartKey();
        }

        List<CartItem> memberCartItems = cartItemDao.findCartItems(memberCart.getId());
        if (memberCartItems.isEmpty()) { // 同步商品
            for (CartItem cartItem : cartKeyCartItems ) {
                addCartItem(cartItem.getQuantity(), memberCart.getId(), cartItem.getProduct());
            }
            return memberCart.getCartKey();
        }

        Map<Integer, CartItem> cartKeyCartItemsMap = new HashMap<>();

        for (CartItem cartItem : cartKeyCartItems ) {
            cartKeyCartItemsMap.put(cartItem.getProduct(), cartItem);// product：cartItem
        }

        for (CartItem memberCartItem : memberCartItems ) {
            // 获取cartKeyCartItems中是否存在这个商品
            CartItem cartKeyCartItem = cartKeyCartItemsMap.get(memberCartItem.getProduct());
            if (cartKeyCartItem == null) {
                continue;
            }
            if (cartKeyCartItem.getQuantity().equals(memberCartItem.getQuantity())) {
                cartKeyCartItemsMap.remove(cartKeyCartItem.getProduct()); // 将浏览器中的商品移除map
                continue;
            }

            cartKeyCartItemsMap.remove(cartKeyCartItem.getProduct()); // 将浏览器中的商品移除map
            // 更新是将浏览器中商品数量更新到用户商品
            cartItemDao.updateCartQuantity(cartKeyCartItem.getQuantity(), memberCartItem.getId());
        }

        for (Integer productId: cartKeyCartItemsMap.keySet()) {
            // 插入到用户的购物车
            CartItem cartItem = cartKeyCartItemsMap.get(productId);
            addCartItem(cartItem.getQuantity(), memberCart.getId(), productId);
        }

        return memberCart.getCartKey();
    }

    public String syncCartInResgiter(Integer memberId, String cartKey) {

        if (memberId == null) {
            return cartKey;
        }

        if(StringUtils.isEmpty(cartKey)){
            Cart cart = insert(cartKey, memberId);// 新增用户购物车
            return  cart.getCartKey();
        }

        Cart cartKeyCart  =  cartDao.findByCartKey(cartKey);
        if(cartKeyCart == null){// 该cartKey不存在添加新的
            Cart cart = insert(cartKey, memberId);// 新增用户购物车
            return  cart.getCartKey();
        }

        if(cartKeyCart.getMember() != null){// 同步商品
            // 查询cartKeyItems
            List<CartItem> cartItems = cartItemDao.findCartItems(cartKeyCart.getId());
            Cart cart = insert(cartKey, memberId);// 新增用户购物车
            for (CartItem cartItem :cartItems){
                addCartItem(cartItem.getQuantity(), cart.getId(), cartItem.getProduct());
            }
          return cart.getCartKey();
        }else{
            cartDao.updateMember(cartKeyCart.getId(), memberId);
            return cartKeyCart.getCartKey();
        }
    }


    /**
     * 添加购物车信息
     * @param cartKey 购物车的Key
     * @param member 用户ID
     */
    private Cart insert(String cartKey, Integer member) {
        Cart cart = new Cart();
        if (StringUtils.isBlank(cartKey)) {
            cartKey = DigestUtils.md5Hex(UUID.randomUUID() + RandomStringUtils.randomAlphabetic(30));
        }
        cart.setCartKey(cartKey);
        Date now = new Date();
        cart.setCreateDate(now);
        cart.setExpire(new Date(now.getTime() + Cart.TIMEOUT));
        cart.setMember(member);
        cart.setModifyDate(now);
        cart.setVersion(0);
        cartDao.insert(cart);
        return cart;
    }

    /**
     * 添加购物车明细
     * @param quantity
     * @param cartId
     * @param productId
     */
    private void addCartItem(Integer quantity, Integer cartId, Integer productId) {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setCart(cartId);
        cartItem.setProduct(productId);
        cartItemDao.insert(cartItem);
    }
}
