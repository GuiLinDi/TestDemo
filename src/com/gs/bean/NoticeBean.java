package com.gs.bean;

public class NoticeBean {
   private int id;
   private String title;
   private String content;
   private String sendtime;
   private String author;
   private String type;
public NoticeBean() {
	super();
	// TODO Auto-generated constructor stub
}
public NoticeBean(int id, String title, String content, String sendtime, String author, String type) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.sendtime = sendtime;
	this.author = author;
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getSendtime() {
	return sendtime;
}
public void setSendtime(String sendtime) {
	this.sendtime = sendtime;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
   
}
