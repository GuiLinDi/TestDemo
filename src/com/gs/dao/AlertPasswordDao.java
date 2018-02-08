package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gs.db.DBUtil;

public class AlertPasswordDao {
	public void updatepassword(String usercode,String userpassword){
		Connection conn = null;
		PreparedStatement prst = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "update t_users set password = '"+userpassword+"' where usercode = '"+usercode+"'";
			prst = conn.prepareStatement(sql);
			prst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
//	public boolean selectpassword(String usercode,String userpassword){
//		boolean bl = false;
//		Connection conn = null;
//		PreparedStatement prst = null;
//		try{
//			conn = DBUtil.getConnection();
//			String sql = "select * from t_users where usercode = '"+usercode+"' and userpassword = '" +userpassword+"'";
//			prst = conn.prepareStatement(sql);
//			ResultSet rs = prst.executeQuery();
//			while(rs.next()){
//				bl = true;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			DBUtil.closeConnection(conn);
//		}
//		return bl;
//	}
}
