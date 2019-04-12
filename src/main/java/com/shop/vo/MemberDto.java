package com.shop.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberDto implements Serializable {
	
	private String username;
	private String password; 
	private String rePassword; 
	private String email; 
	private String name; 
	private Integer gender;
	private String mobile;
	private String phone;
	private String verifyCode;
	private String phoneVerifyCode;

}
