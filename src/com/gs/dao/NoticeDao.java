package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.ContacterBean;
import com.gs.bean.NoticeBean;
import com.gs.db.DBUtil;
import com.gs.page.PageSQL;

public class NoticeDao {
      public void add(NoticeBean notice) {
    	  Connection conn=null;
    	  PreparedStatement pst=null;
    	  try {
    		  conn=DBUtil.getConnection();
    		  String sql="insert into t_notice(title,content,sendtime,author,type) values(?,?,?,?,?)";
    		  pst=conn.prepareStatement(sql);
    		  pst.setString(1,notice.getTitle() );
    		  pst.setString(2,notice.getContent() );
    		  pst.setString(3, notice.getSendtime());
    		  pst.setString(4,notice.getAuthor());
    		  pst.setString(5, notice.getType());
    		  pst.executeUpdate();
    	  }catch(Exception e){
    		  e.printStackTrace();
    	  }finally {
    		  DBUtil.closeConnection(conn);
    	  }
    	  
      }
      public void delete(String id) {
    	  Connection conn=null;
    	  PreparedStatement pst=null;
    	  try {
    		  conn=DBUtil.getConnection();
    		  String sql="delete from t_notice where id=?";
    		  pst=conn.prepareStatement(sql);
    		  pst.setString(1, id);
    		  pst.executeUpdate();
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }finally {
    		  DBUtil.closeConnection(conn);
    	  }
       }
     public void update(NoticeBean notice) {
    	 Connection conn=null;
    	 PreparedStatement pst=null;
    	 try {
    		 conn=DBUtil.getConnection();
    		 String sql="update t_notice set title=?,content=?,sendtime=? where id=?";
    		 pst=conn.prepareStatement(sql);
    		 pst.setString(1, notice.getTitle());
    		 pst.setString(2, notice.getContent());
    		 pst.setString(3, notice.getSendtime());
    		 pst.setInt(4, notice.getId());
    		 
    		 pst.executeUpdate();
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 DBUtil.closeConnection(conn);
    	 }
     }
     public List pageSelect(String title,String type,int beg,int pageSize){
 		List list = new ArrayList();
 		Connection conn = null;
 		PreparedStatement pst = null;
 		ResultSet rs = null;
 		try{
 			conn = DBUtil.getConnection();
 			String sql= "select * from t_notice ";
 			if(type!=null&&!type.equals("")){
 				sql+=" where type= '"+type+"'";
 			}
 			if(title!=null&&!title.equals("")){
 				sql+=" where title= '"+title+"'";
 			}
 			sql = PageSQL.pageSql(sql);
 			//sql ="select * from salary where usercode='aa'  limit ?,?  "
 			pst = conn.prepareStatement(sql);
 			pst.setInt(1, beg);
 			pst.setInt(2, pageSize);
 			rs=pst.executeQuery();
 			 
 			while(rs.next()){
 				NoticeBean notice= new NoticeBean();
 				notice.setId(Integer.parseInt(rs.getString(1)));
 				notice.setTitle(rs.getString(2));
 				notice.setContent(rs.getString(3));
 				notice.setSendtime(rs.getString(4));
 				list.add(notice);
 			}
 		}catch(Exception e){
 			e.printStackTrace();
 		}finally{
 			DBUtil.closeConnection(conn);
 		}
 		return list;
 	}
     public NoticeBean selectById(String id) {
  	   Connection conn=null;
  	   PreparedStatement pst=null;
  	   ResultSet rs=null;
  	   NoticeBean notice=new NoticeBean();
  	   try {
  	    conn=DBUtil.getConnection();
  	    String sql="select* from t_notice where id=?";
  	    pst=conn.prepareStatement(sql);
  	    pst.setString(1,id);
  	    rs=pst.executeQuery();
  	    if(rs.next()) {
  	    	notice.setId(rs.getInt(1));
  	    	notice.setTitle(rs.getString(2));
  	    	notice.setContent(rs.getString(3));
  	    	notice.setSendtime(rs.getString(4));
  	    }
  	   }catch(Exception e) {
  	    e.printStackTrace();
  	   }finally {
  	    DBUtil.closeConnection(conn);
  	   }
  	   return notice;
  	  }
}

