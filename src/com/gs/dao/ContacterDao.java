package com.gs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gs.bean.ContacterBean;
import com.gs.db.DBUtil;

public class ContacterDao {
         public void add(ContacterBean contacter){
        	
        	 Connection conn=null;
        	 PreparedStatement pst=null;
        	 try {
        		 conn=DBUtil.getConnection();
        		 String sql="insert into t_contacter(usercode,namees,sex,telephone,qq,company,address,post) values(?,?,?,?,?,?,?,?)";
        		 pst=conn.prepareStatement(sql);
        		 pst.setString(1,contacter.getUsercode());
        		 pst.setString(2,contacter.getNamees());
        		 pst.setString(3, contacter.getSex());
        		 pst.setString(4, contacter.getTelephone());
        		 pst.setString(5, contacter.getQq());
        		 pst.setString(6, contacter.getCompany());
        		 pst.setString(7, contacter.getAddress());
        		 pst.setString(8, contacter.getPost());
        	     pst.executeUpdate();
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }finally {
        		 DBUtil.closeConnection(conn);
        	 }
         }
         public List select(String usercode,String id) {
        	 List list=new ArrayList();
        	 Connection conn=null;
        	 Statement pst=null;
        	 ResultSet rs=null;
        	 try {
        		 conn=DBUtil.getConnection();
        		 String sql="select* from t_contacter where 1=1";
        		 if(usercode!=null&&!usercode.equals("")) {
        			 sql+=" and usercode='"+usercode+"'"; 
        		 }
        		 if(id!=null&&!id.equals("")) {
        			 sql+=" and namees='"+id+"'";
        		 }
        		 pst=conn.createStatement();
        		 rs=pst.executeQuery(sql);
        		 while(rs.next()) {
        			 ContacterBean contacter=new ContacterBean();
        			 contacter.setId(rs.getInt(1));
        			 contacter.setUsercode(rs.getString(2));
        			 contacter.setNamees(rs.getString(3));
        			 contacter.setSex(rs.getString(4));
        			 contacter.setTelephone(rs.getString(5));
        			 contacter.setQq(rs.getString(6));
        			 contacter.setCompany(rs.getString(7));
        			 contacter.setAddress(rs.getString(8));
        			 contacter.setPost(rs.getString(9));
        			 list.add(contacter);
        		 }
        	 }catch(Exception e) {
        		 e.printStackTrace();
        	 }finally {
        		 DBUtil.closeConnection(conn);
        	 }
        	 return list;
         }
         public void delete(String id) {
        	 Connection conn=null;
        	 PreparedStatement pst=null;
        	 try {
        		 conn=DBUtil.getConnection();
        		 String sql="delete from t_contacter where id=? ";
        		 pst=conn.prepareStatement(sql);
        		 pst.setString(1, id);
        		 pst.executeUpdate();
        	 }catch(Exception e){
        		 e.printStackTrace();
        	 }finally {
        		 DBUtil.closeConnection(conn);
        	 }
         }
        public ContacterBean selectById(String id) {
        	   Connection conn=null;
        	   PreparedStatement pst=null;
        	   ResultSet rs=null;
        	   ContacterBean contacter=new ContacterBean();
        	   try {
        	    conn=DBUtil.getConnection();
        	    String sql="select* from t_contacter where id=?";
        	    pst=conn.prepareStatement(sql);
        	    pst.setString(1,id);
        	    rs=pst.executeQuery();
        	    if(rs.next()) {
        	    	contacter.setId(rs.getInt(1));
        	    	contacter.setUsercode(rs.getString(2));
        	    	contacter.setNamees(rs.getString(3));
        	    	contacter.setSex(rs.getString(4));
        	    	contacter.setTelephone(rs.getString(5));
        	    	contacter.setQq(rs.getString(6));
        	    	contacter.setCompany(rs.getString(7));
        	    	contacter.setAddress(rs.getString(8));
        	    	contacter.setPost(rs.getString(9));
        	    }
        	   }catch(Exception e) {
        	    e.printStackTrace();
        	   }finally {
        	    DBUtil.closeConnection(conn);
        	   }
        	   return contacter;
        	  }
        public void update(ContacterBean contacter) {
        	Connection conn=null;
        	PreparedStatement pst=null;
        	try {
        		conn=DBUtil.getConnection();
        		String sql="update t_contacter set namees=?,sex=?,telephone=?,qq=?,company=?,address=?,post=? where id=?";
        		pst=conn.prepareStatement(sql);
        		pst.setString(1,contacter.getNamees());
        		pst.setString(2,contacter.getSex() );
        		pst.setString(3,contacter.getTelephone() );
        		pst.setString(4,contacter.getQq() );
        		pst.setString(5,contacter.getCompany() );
        		pst.setString(6,contacter.getAddress());
        		pst.setString(7,contacter.getPost());
        		pst.setInt(8,contacter.getId());
        		pst.executeUpdate();
        	}catch(Exception e) {
        		e.printStackTrace();
        	}finally {
        	   DBUtil.closeConnection(conn);
        	}
        	
        }
}
