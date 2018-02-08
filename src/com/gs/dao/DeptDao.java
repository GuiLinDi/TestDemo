package com.gs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.DeptBean;
import com.gs.db.DBUtil;

public class DeptDao {
	public void add(DeptBean dept){
		Connection conn = null;
		PreparedStatement pst = null;
		try{
			  conn =DBUtil.getConnection();
			    String sql = " insert into t_dept values(?,?,?)";
			    pst =conn.prepareStatement(sql);
			    pst.setInt(1, dept.getDeptid());
			    pst.setString(2,dept.getDeptname());
			    pst.setString(3,dept.getRemark());
				pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		
	} 
	public List select(String deptname,String deptid){
		Connection conn = null;
		Statement pst = null;
		ResultSet rs = null;
		List dateList = new ArrayList();
		try{
			conn = DBUtil.getConnection();
			pst = conn.createStatement();
			String sql = "select * from t_dept where 1=1";
			 if(deptname!=null&&!deptname.equals("")) {
    			 sql+=" and deptname='"+deptname+"'"; 
    		 }
    		 if(deptid!=null&&!deptid.equals("")) {
    			 sql+=" and deptid='"+deptid+"'";
    		 }
			rs = pst.executeQuery(sql);
			while(rs.next()){
				DeptBean dept = new DeptBean();
				dept.setDeptid(rs.getInt(1));
				dept.setDeptname(rs.getString(2));
				dept.setRemark(rs.getString(3));
				dateList.add(dept);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return dateList;
	}
	public void delete(int deptid){
		Connection conn = null;
		PreparedStatement pst = null;
		 try {
		    conn =DBUtil.getConnection();
		    String sql = " delete from t_dept where deptid=?  ";
			pst =conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			pst.executeUpdate();
		 } catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeConnection(conn);
				}
	}
	public void update( DeptBean dept ){
		Connection conn = null;
		PreparedStatement pst = null;
		 try {
			  conn =DBUtil.getConnection();
			    String sql = " update t_dept set remark= ?,deptname = ? where  deptid = ? ";
			    pst=conn.prepareStatement(sql);				
				pst.setString(1,dept.getRemark());
				pst.setString(2,dept.getDeptname());
				pst.setInt(3,dept.getDeptid());
				pst.executeUpdate();
		 } catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeConnection(conn);
				}
	}
	  public boolean check(String deptname) {
	    	boolean f=false;
	    	Connection conn=null;
	    	Statement pst=null;
	    	ResultSet rs=null;
	    	try {
				conn=DBUtil.getConnection();
				String sql="select * from t_dept where deptname='"+deptname+"'";
				pst=conn.createStatement();
				rs=pst.executeQuery(sql);
				if(!rs.next()) {
					f=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.closeConnection(conn);
			}
	    	return f;
	    }
	public DeptBean selectById(int deptid){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DeptBean dept = new DeptBean();
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from t_dept where deptid=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			rs = pst.executeQuery();
			if(rs.next()){
				dept.setDeptid(rs.getInt(1));
				dept.setDeptname(rs.getString(2));
				dept.setRemark(rs.getString(3));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return dept;
	}
	}
