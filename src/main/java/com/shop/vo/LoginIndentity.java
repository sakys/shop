package com.shop.vo;

import lombok.Data;

@Data
public class LoginIndentity {

    private Integer id;
    private String username;
    private String email;
    private String phone;
    private String cartKey;
}
