package com.gs.bean;

public class upFile {
	private int id;
	private String filename;
	private String fileuper;
	private String filetime;
	private String fileinfo;
	public upFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public upFile(String filename, String fileuper, String filetime,
			String fileinfo) {
		super();
		this.filename = filename;
		this.fileuper = fileuper;
		this.filetime = filetime;
		this.fileinfo = fileinfo;
	}
	public upFile(int id, String filename, String fileuper, String filetime,
			String fileinfo) {
		super();
		this.id = id;
		this.filename = filename;
		this.fileuper = fileuper;
		this.filetime = filetime;
		this.fileinfo = fileinfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileuper() {
		return fileuper;
	}
	public void setFileuper(String fileuper) {
		this.fileuper = fileuper;
	}
	public String getFiletime() {
		return filetime;
	}
	public void setFiletime(String filetime) {
		this.filetime = filetime;
	}
	public String getFileinfo() {
		return fileinfo;
	}
	public void setFileinfo(String fileinfo) {
		this.fileinfo = fileinfo;
	}	
}
