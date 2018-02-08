package com.gs.bean;

public class Joblog {
		private int id;
		private String usercode;
		private String times;
		private String title;
		private String contend;
		private String rectime;
		private String type;
		public Joblog() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Joblog(int id,String usercode,String times,String title,
				String contend,String rectime,String type) {
			super();
			this.id = id;
			this.usercode = usercode;
			this.times = times;
			this.title = title;
			this.contend = contend;
			this.rectime = rectime;
			this.type = type;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
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
		public String getTimes() {
			return times;
		}
		public void setTimes(String times) {
			this.times = times;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContend() {
			return contend;
		}
		public void setContend(String contend) {
			this.contend = contend;
		}
		public String getRectime() {
			return rectime;
		}
		public void setRectime(String rectime) {
			this.rectime = rectime;
		}
		
}
