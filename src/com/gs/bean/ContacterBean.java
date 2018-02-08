package com.gs.bean;

public class ContacterBean {
	 private int id;
     private String usercode;
     private String namees;
     private String sex;
     private String telephone;
     private String qq;
     private String company;
     private String address;
     private String post;
	public ContacterBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContacterBean(int id, String usercode, String namees, String sex, String telephone, String qq,
			String company, String address, String post) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.namees = namees;
		this.sex = sex;
		this.telephone = telephone;
		this.qq = qq;
		this.company = company;
		this.address = address;
		this.post = post;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getNamees() {
		return namees;
	}
	public void setNamees(String namees) {
		this.namees = namees;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	
}