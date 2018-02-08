package com.gs.bean;

public class PageBean {
	private int curPage;//当前的页数
	private int itemCount;//总数据(总记录数)
	private int totalPage;//总页数
	private int pageSize=5;//每页显示多少条数据
	private int beg;//开始的记录数
	private String url;//页面转换url
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getTotalPage() {
		totalPage =itemCount%pageSize==0?
				itemCount/pageSize:itemCount/pageSize+1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBeg() {
		beg = (curPage-1)*pageSize;
		return beg;
	}
	public void setBeg(int beg) {
		this.beg = beg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
