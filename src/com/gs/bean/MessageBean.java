package com.gs.bean;

public class MessageBean {
	private int id;
	private String sender;
	private String receiver;
	private String content;
	private String sendtime;
	public MessageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageBean(int id, String sender, String receiver, String content, String sendtime) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.sendtime = sendtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	
}
