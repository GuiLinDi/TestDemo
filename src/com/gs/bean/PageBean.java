package com.gs.bean;

public class PageBean {
	private int curPage;//��ǰ��ҳ��
	private int itemCount;//������(�ܼ�¼��)
	private int totalPage;//��ҳ��
	private int pageSize=5;//ÿҳ��ʾ����������
	private int beg;//��ʼ�ļ�¼��
	private String url;//ҳ��ת��url
	
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
