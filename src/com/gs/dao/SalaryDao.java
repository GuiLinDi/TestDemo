package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.MessageBean;
import com.gs.bean.SalaryBean;
import com.gs.bean.UserBean;
import com.gs.db.DBUtil;
import com.gs.page.PageSQL;

public class SalaryDao {
	public void add(SalaryBean salary) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_salary values(?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, salary.getId());
			pst.setString(2, salary.getUsercode());
			pst.setFloat(3, salary.getBase());
			pst.setFloat(4, salary.getBonus());
			pst.setFloat(5, salary.getTakeoff());
			pst.setFloat(6, salary.getSafe());
			pst.setFloat(7, salary.getOther());
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from t_salary where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public void update(SalaryBean salary) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update t_salary set usercode=?,base=?,bonus=?,takeoff=?,safe=?,other=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, salary.getUsercode());
			pst.setFloat(2, salary.getBase());
			pst.setFloat(3, salary.getBonus());
			pst.setFloat(4, salary.getTakeoff());
			pst.setFloat(5, salary.getSafe());
			pst.setFloat(6, salary.getOther());
			pst.setInt(7, salary.getId());
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public List pageSelect(String usercode,int beg,int pageSize){
		List list = new ArrayList();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql= "select * from t_salary ";
			if(usercode!=null&&!usercode.equals("")){
				sql+=" where usercode= '"+usercode+"'";
			}
			sql = PageSQL.pageSql(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, beg);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				SalaryBean salary = new SalaryBean();
				salary.setId(rs.getInt(1));
				salary.setUsercode(rs.getString(2));
				salary.setBase(rs.getFloat(3));
				salary.setBonus(rs.getFloat(4));
				salary.setTakeoff(rs.getFloat(5));
				salary.setSafe(rs.getFloat(6));
				salary.setOther(rs.getFloat(7));
				list.add(salary);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	public SalaryBean selectById(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		SalaryBean salary = new SalaryBean();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_salary where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				salary.setId(rs.getInt(1));
				salary.setUsercode(rs.getString(2));
				salary.setBase(rs.getFloat(3));
				salary.setBonus(rs.getFloat(4));
				salary.setTakeoff(rs.getFloat(5));
				salary.setSafe(rs.getFloat(6));
				salary.setOther(rs.getFloat(7));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return salary;
	}
}
