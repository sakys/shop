package com.shop.base;

public class ResultInfo {
	
	private int resultCode;
	private String resultMessage;
	private Object result;
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	public ResultInfo() {
	}
	public ResultInfo(int resultCode, String message, Object result) {
		this.resultCode = resultCode;
		this.resultMessage = message;
		this.result = result;
	}
	public ResultInfo(int resultCode, String message) {
		this.resultCode = resultCode;
		this.resultMessage = message;
	}
}
