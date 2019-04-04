package com.shop.base;

import javax.servlet.http.HttpServletRequest;

import com.shop.constant.Constant;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
	
	@ModelAttribute
	public void preMethod(Model model, HttpServletRequest request) {
		String ctx = request.getContextPath();
		model.addAttribute("ctx", ctx);
	}
	
	/**
	 * encapsulate success function
	 * @param result
	 * @return
	 */
	protected ResultInfo success(Object result) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultMessage(Constant.SUCCESS_MESSAGE);
		resultInfo.setResultCode(Constant.SUCCESS_CODE);
		resultInfo.setResult(result);
		return resultInfo;
	}
	
	/**
	 * encapsulate failure function
	 * @return
	 */
	protected ResultInfo failure(int errorCode, String message) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultMessage(message);
		resultInfo.setResultCode(errorCode);
		return resultInfo;
	}
	
	/**
	 * encapsulate failure function
	 * @return
	 */
	protected ResultInfo failure(int errorCode) {
		return failure(errorCode, Constant.ERROR_MESSAGE);
	}
	
	/**
	 * encapsulate failure function
	 * @return
	 */
	protected ResultInfo failure(String errorMessage) {
		return failure(Constant.ERROR_CODE, errorMessage);
	}
	
}
