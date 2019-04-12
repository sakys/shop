package com.shop.service;

import com.shop.dao.MemberDao;
import com.shop.model.Member;
import com.shop.util.AssertUtil;
import com.shop.util.MD5;
import com.shop.vo.LoginIndentity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Beans;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private CartService cartService;

    public LoginIndentity login(String userName, String password, String verifyCode, String sessionVerifyCode, String cartKey) {

        // 基本参数验证——非空以及验证码是否正确
        AssertUtil.notNull(userName, "请输入用户名或邮箱");
        AssertUtil.notNull(password, "请输入密码");
        AssertUtil.notNull(verifyCode, "请输入验证码");
        AssertUtil.isTrue(!verifyCode.equals(sessionVerifyCode), "验证码输入有误，请重新输入");
        // 根据userName(username, email) 去数据库查询 --验证
        Member member = memberDao.findByUserNameOrEmail(userName);
        AssertUtil.isTrue(member == null, "用户名或者密码错误，请重新输入");

        password = MD5.toMD5(password);
        AssertUtil.isTrue(!password.equals(member.getPassword()), "用户名或者密码错误，请重新输入");

        // 同步购物车
        // 先获取用户的购物车信息——判断用户的购物车是否和 浏览器的cartKey的购物车是否为同一个
        // 获取cartKey的购物车信息
        // 获取购物车的商品以及cartKey的商品进行比对：主要判断商品是否相同以及数量是否一致
        cartKey = cartService.syncCart(member.getId(), cartKey);

        LoginIndentity loginIndentity = new LoginIndentity();
        BeanUtils.copyProperties(member, loginIndentity);
        loginIndentity.setCartKey(cartKey);

        return loginIndentity;
    }
}
