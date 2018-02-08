package com.gs.bean;

public class SalaryBean {
	private int id;
	private String usercode;
	private float base;
	private float bonus;
	private float takeoff;
	private float safe;
	private float other;
	public SalaryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalaryBean(int id, String usercode, float base, float bonus, float takeoff, float safe, float other) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.base = base;
		this.bonus = bonus;
		this.takeoff = takeoff;
		this.safe = safe;
		this.other = other;
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
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public float getTakeoff() {
		return takeoff;
	}
	public void setTakeoff(float takeoff) {
		this.takeoff = takeoff;
	}
	public float getSafe() {
		return safe;
	}
	public void setSafe(float safe) {
		this.safe = safe;
	}
	public float getOther() {
		return other;
	}
	public void setOther(float other) {
		this.other = other;
	}
	
}
