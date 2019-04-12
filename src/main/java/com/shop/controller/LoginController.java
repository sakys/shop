package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController extends BaseController {


    @RequestMapping("login")
    public String login(String redirectUrl, Model model){
          model.addAttribute("redirectUrl",redirectUrl);
        return "user/login";
    }

    @RequestMapping("register")
    public String register(String redirectUrl, Model model) {
        model.addAttribute("redirectUrl", redirectUrl);
        return "user/register";
    }

    @RequestMapping("logout")
    public  String logout(HttpServletRequest request){
           request.getSession().removeAttribute(Constant.USER_SESSION_KEY);
        return  "redirect:index";
    }

}
