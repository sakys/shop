package com.shop.controller;

import com.google.code.kaptcha.Constants;
import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import com.shop.constant.Constant;
import com.shop.service.MemberService;
import com.shop.util.WebUtils;
import com.shop.vo.LoginIndentity;
import com.shop.vo.MemberDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private MemberService memberService;


    @RequestMapping("login")
    public ResultInfo login(String userName, String password,
                            String verifyCode, HttpServletRequest request, HttpServletResponse response) {

        String sessionVerifyCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String cartKey = WebUtils.getCookie(request, Constant.CART_COOKIE_KEY);
        LoginIndentity loginIndentity = memberService.login(userName, password, verifyCode, sessionVerifyCode, cartKey);

        if (StringUtils.isNoneBlank(loginIndentity.getCartKey())) {
            WebUtils.addCookie(request, response, Constant.CART_COOKIE_KEY, loginIndentity.getCartKey());
        }
        request.getSession().setAttribute(Constant.USER_SESSION_KEY, loginIndentity);

        return success("登陆成功");
    }


    @RequestMapping("register")
    public ResultInfo register(MemberDto memberDto, HttpServletRequest request, HttpServletResponse response) {

        return null;
    }


}
