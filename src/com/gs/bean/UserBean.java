package com.gs.bean;

public class UserBean {
	  private String usercode;
	  private int deptid;
	  private String boss;
	  private String username;
	  private String password;
	  private String email;
	  private String telephone;
	  private String job;
	  private String sex;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(String usercode, int deptid,  String username, String password, String email,
			String telephone, String job, String sex,String boss) {
		super();
		this.usercode = usercode;
		this.deptid = deptid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
		this.job = job;
		this.sex = sex;
		this.boss = boss;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	  
}
