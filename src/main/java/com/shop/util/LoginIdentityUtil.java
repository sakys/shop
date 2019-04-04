package com.shop.util;

import com.shop.constant.Constant;
import com.shop.vo.LoginIndentity;

import javax.servlet.http.HttpServletRequest;


public class LoginIdentityUtil {
	
	public static LoginIndentity getFromSession(HttpServletRequest request) {
		LoginIndentity loginIndentity = (LoginIndentity) request.getSession()
				.getAttribute(Constant.USER_SESSION_KEY);
		return loginIndentity;
	}
	
	public static Integer getFromLoginId(HttpServletRequest request) {
		LoginIndentity loginIndentity = (LoginIndentity) request.getSession()
				.getAttribute(Constant.USER_SESSION_KEY);
		if (loginIndentity != null) {
			return loginIndentity.getId();
		} 
		return null;
	}
	
	
}
