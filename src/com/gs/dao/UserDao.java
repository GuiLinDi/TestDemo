package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.MessageBean;
import com.gs.bean.UserBean;
import com.gs.db.DBUtil;
import com.gs.page.PageSQL;

public class UserDao {
	public UserBean login(String usercode,String password){
		UserBean user=new UserBean();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from t_users where usercode=? and password=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,usercode);
			pst.setString(2,password);
			rs = pst.executeQuery();
			if(rs.next()){
				user.setUsercode(rs.getString(1));
				user.setDeptid(rs.getInt(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setJob(rs.getString(7));
				user.setSex(rs.getString(8));
				user.setBoss(rs.getString(9));
				System.out.println(user.getUsercode());
				System.out.println(user.getPassword());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return user;
	}
	public void add(UserBean user) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_users values(?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsercode());
			pst.setInt(2, user.getDeptid());
			pst.setString(3, user.getUsername());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getTelephone());
			pst.setString(7, user.getJob());
			pst.setString(8, user.getSex());
			pst.setString(9, user.getBoss());
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void delete(String usercode) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from t_users where usercode=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, usercode);
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void update(UserBean user) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update t_users set deptid=?,username=?,password=?,email=?,telephone=?,job=?,sex=?,boss=? where usercode=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user.getDeptid());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getTelephone());
			pst.setString(6, user.getJob());
			pst.setString(7, user.getSex());
			pst.setString(8, user.getBoss());
			pst.setString(9, user.getUsercode());
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public List pageSelect(String ucode,String uname,int beg,int pageSize){
		List list = new ArrayList();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_users where 1=1";
			if(ucode!=null&&!ucode.equals("")) {
				sql+=" and usercode = '"+ucode+"'";
			}
			if(uname!=null&&!uname.equals("")) {
				sql+=" and username = '"+uname+"'";
			}
			sql = PageSQL.pageSql(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, beg);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setUsercode(rs.getString(1));
				user.setDeptid(rs.getInt(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setJob(rs.getString(7));
				user.setSex(rs.getString(8));
				user.setBoss(rs.getString(9));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	public List select(String ucode,String uname) {
		List list = new ArrayList();
		Connection conn = null;
		Statement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_users where 1=1";
			if(ucode!=null&&!ucode.equals("")) {
				sql+=" and usercode = '"+ucode+"'";
			}
			if(uname!=null&&!uname.equals("")) {
				sql+=" and username = '"+uname+"'";
			}
			pst = conn.createStatement();
			rs = pst.executeQuery(sql);
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setUsercode(rs.getString(1));
				user.setDeptid(rs.getInt(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setTelephone(rs.getString(6));
				user.setJob(rs.getString(7));
				user.setSex(rs.getString(8));
				user.setBoss(rs.getString(9));
				list.add(user);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	public UserBean selectById(String ucode) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		UserBean user = new UserBean();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_users where usercode=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, ucode);
			rs = pst.executeQuery();
			if(rs.next()) {
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
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return user;
	}
	
}
