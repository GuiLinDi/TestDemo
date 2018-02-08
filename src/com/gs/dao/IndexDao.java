package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.Joblog;
import com.gs.bean.MessageBean;
import com.gs.bean.NoticeBean;
import com.gs.db.DBUtil;

public class IndexDao {
	public List selectMessage(String usercode) {
		List list=new ArrayList();
	    Connection conn=null;
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    try {
	      conn=DBUtil.getConnection();
	      String sql="select * from t_message where receiver=? "
	      		+ "order by sendtime desc limit 0,4";
	      pst=conn.prepareStatement(sql);
	      pst.setString(1, usercode); 
	      rs=pst.executeQuery();
	      while(rs.next()) {
	    	  MessageBean message=new MessageBean();
	    	  message.setId(rs.getInt(1));
	    	  message.setSender(rs.getString(2));
	    	  message.setContent(rs.getString(4));
	    	  message.setSendtime(rs.getString(5));
	    	  list.add(message);
	      }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	DBUtil.closeConnection(conn);
	    }
	    return list;
  }
	public List selectSchedule(String usercode) {
		List list=new ArrayList();
	    Connection conn=null;
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    try {
	      conn=DBUtil.getConnection();
	      String sql="select * from t_joblog where usercode=? and type='1' "
	      		+ "order by rectime desc limit 0,6";
	      pst=conn.prepareStatement(sql);
	      pst.setString(1, usercode); 
	      rs=pst.executeQuery();
	      while(rs.next()) {
	    	  Joblog jb =new Joblog();
	    	  jb.setId(rs.getInt(1));
	    	  jb.setUsercode(rs.getString(2));
	    	  jb.setTimes(rs.getString(3));
	    	  jb.setTitle(rs.getString(4));
	    	  jb.setContend(rs.getString(5));
	    	  jb.setRectime(rs.getString(6));
	    	  list.add(jb);
	      }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	DBUtil.closeConnection(conn);
	    }
	    return list;
  }
	public List selectLog(String usercode) {
		List list=new ArrayList();
	    Connection conn=null;
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    try {
	      conn=DBUtil.getConnection();
	      String sql="select * from t_joblog where usercode=? and type='2' "
	      		+ "order by rectime desc limit 0,6";
	      pst=conn.prepareStatement(sql);
	      pst.setString(1, usercode); 
	      rs=pst.executeQuery();
	      while(rs.next()) {
	    	  Joblog jb =new Joblog();
	    	  jb.setId(rs.getInt(1));
	    	  jb.setUsercode(rs.getString(2));
	    	  jb.setTimes(rs.getString(3));
	    	  jb.setTitle(rs.getString(4));
	    	  jb.setContend(rs.getString(5));
	    	  jb.setRectime(rs.getString(6));
	    	  list.add(jb);
	      }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	DBUtil.closeConnection(conn);
	    }
	    return list;
  }
	
	public List selectMeeting() {
		List list=new ArrayList();
	    Connection conn=null;
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    try {
	      conn=DBUtil.getConnection();
	      String sql="select * from t_notice where type='2' "
	      		+ "order by sendtime desc limit 0,3";
	      pst=conn.prepareStatement(sql); 
	      rs=pst.executeQuery();
	      while(rs.next()) {
	    	  NoticeBean notice=new NoticeBean();
	    	  notice.setId(rs.getInt(1));
	    	  notice.setTitle(rs.getString(2));
	    	  notice.setContent(rs.getString(3));
	    	  notice.setSendtime(rs.getString(4));
	    	  list.add(notice);
	      }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	DBUtil.closeConnection(conn);
	    }
	    return list;
  }
	public List selectFile() {
		List list=new ArrayList();
	    Connection conn=null;
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	    try {
	      conn=DBUtil.getConnection();
	      String sql="select * from  where type='2' "
	      		+ "order by sendtime desc limit 0,3";
	      pst=conn.prepareStatement(sql); 
	      rs=pst.executeQuery();
	      while(rs.next()) {
	    	  NoticeBean notice=new NoticeBean();
	    	  notice.setId(rs.getInt(1));
	    	  notice.setTitle(rs.getString(2));
	    	  notice.setContent(rs.getString(3));
	    	  notice.setSendtime(rs.getString(4));
	    	  list.add(notice);
	      }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	DBUtil.closeConnection(conn);
	    }
	    return list;
  }
	
}
