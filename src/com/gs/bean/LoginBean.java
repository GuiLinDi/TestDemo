package com.gs.bean;

public class LoginBean {
	private String usercode;
	private String password;
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginBean(String usercode, String password) {
		super();
		this.usercode = usercode;
		this.password = password;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
