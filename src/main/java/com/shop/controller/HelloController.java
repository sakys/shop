package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/freemarker")
public class HelloController {

    @RequestMapping("directive")
    public String directive(){
        return  "/hello";
    }

}
