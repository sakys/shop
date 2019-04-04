package com.shop.model;

public class User {
	
	private int id;
	private String userName;
	private String password;
	private int gender;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + id + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ "]";
	}
	
}
