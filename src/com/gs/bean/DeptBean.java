package com.gs.bean;

public class DeptBean {
    private int deptid;
    private String deptname;
    private String remark;
	public DeptBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeptBean(int deptid, String deptname, String remark) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.remark = remark;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
