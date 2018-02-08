package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.DeptBean;
import com.gs.bean.UserBean;
import com.gs.db.DBUtil;

public class CheckDao {
    public UserBean userselect(String ucode) {
    	UserBean user = new UserBean();
    	Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_users where usercode= '"+ucode+"'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				user.setUsercode(rs.getString(1));
				user.setDeptid(rs.getInt(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setJob(rs.getString(7));
				user.setSex(rs.getString(8));
				user.setBoss(rs.getString(9));
			}
		}catch (Exception e) {			
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
    	return user;
    }
    
    public DeptBean deptselect(int deptid) {
    	Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DeptBean dept = new DeptBean();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_dept where deptid = '"+deptid+"'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {				
				dept.setDeptid(rs.getInt(1));
				dept.setDeptname(rs.getString(2));
				dept.setRemark(rs.getString(3));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
    	return dept;
    }
    public UserBean bossselect(String ucode1) {
    	UserBean user = new UserBean();
    	Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_users where usercode= '"+ucode1+"'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				user.setUsercode(rs.getString(1));
				user.setDeptid(rs.getInt(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setJob(rs.getString(7));
				user.setSex(rs.getString(8));
				user.setBoss(rs.getString(9));
			}
		}catch (Exception e) {			
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
    	return user;
    }
}
