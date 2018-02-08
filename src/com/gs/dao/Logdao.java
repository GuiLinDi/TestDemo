package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.Joblog;
import com.gs.db.DBUtil;
import com.gs.page.PageSQL;

public class Logdao {
	Connection conn = null;
	PreparedStatement prst = null;
	public void add(Joblog jl){
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_joblog(usercode,times,title,contend,rectime,type) values(?,?,?,?,?,?)";
			prst = conn.prepareStatement(sql);
			prst.setString(1,jl.getUsercode());
			prst.setString(2, jl.getTimes());
			prst.setString(3, jl.getTitle());
			prst.setString(4, jl.getContend());
			prst.setString(5, jl.getRectime());
			prst.setString(6, jl.getType());
			prst.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	public void delete(int Joblog_id){
		conn = DBUtil.getConnection();
		String sql = "delete from t_joblog where id = ?";
		try {
			prst = conn.prepareStatement(sql);
			prst.setInt(1,Joblog_id);
			prst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	public void update(Joblog jl){
		try{
		conn  = DBUtil.getConnection();
		String sql = "update t_joblog set usercode=?,times=?,title=?,contend=?,rectime=?,type=? where id=?";
		prst = conn.prepareStatement(sql);
		prst.setString(1, jl.getUsercode());
		prst.setString(2, jl.getTimes());
		prst.setString(3, jl.getTitle());
		prst.setString(4, jl.getContend());
		prst.setString(5, jl.getRectime());
		prst.setString(6, jl.getType());
		prst.setInt(7, jl.getId());
		System.out.println(jl.getUsercode()+jl.getTimes()+jl.getType()+jl.getId());
		prst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	public List select(String usercode){
		List datalist = new ArrayList();
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		String sql = "select * from t_joblog where usercode = '"+usercode+"'";
	
		try{
		conn = DBUtil.getConnection();
		prst = conn.prepareStatement(sql);
		rs  = prst.executeQuery();
		while(rs.next()){
			Joblog jl = new Joblog();
			jl.setId(rs.getInt(1));
			jl.setUsercode(rs.getString(2));
			jl.setTimes(rs.getString(3));
			jl.setTitle(rs.getString(4));
			jl.setContend(rs.getString(5));
			jl.setRectime(rs.getString(6));
			jl.setType(rs.getString(7));
			datalist.add(jl);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return datalist;
	}
	public Joblog selectbyid(String joblog_id){
		Joblog jl = new Joblog();
		try{
		conn = DBUtil.getConnection();
		String sql = "select * from t_joblog where id = ?";
		prst = conn.prepareStatement(sql);
		int id = Integer.parseInt(joblog_id);
		prst.setInt(1, id);
		System.out.println(sql);
		ResultSet rs = prst.executeQuery();
		while(rs.next()){
			jl.setId(rs.getInt(1));
			jl.setUsercode(rs.getString(2));
			jl.setTimes(rs.getString(3));
			jl.setTitle(rs.getString(4));
			jl.setContend(rs.getString(5));
			jl.setRectime(rs.getString(6));
			jl.setType(rs.getString(7));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return jl;
		
	}
	public List pageSelect(String usercode,int beg,int pageSize,int ty){
		List datalist = new ArrayList();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql= "select * from t_joblog ";
			if(usercode!=null&&!usercode.equals("")){
				sql+=" where type="+ty+" and usercode= '"+usercode+"'";
			}else{
				sql+="where type="+ty;
			}
			sql = PageSQL.pageSql(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, beg);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				Joblog jl = new Joblog();
				jl.setId(rs.getInt(1));
				jl.setUsercode(rs.getString(2));
				jl.setTimes(rs.getString(3));
				jl.setTitle(rs.getString(4));
				jl.setContend(rs.getString(5));
				jl.setRectime(rs.getString(6));
				jl.setType(rs.getString(7));
				datalist.add(jl);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return datalist;
	}
	
	//下面是二级界面的查询
	public List SecondaryMenuSelect(String usercode,String type){
		List datalist = new ArrayList();
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		String sql = "select * from t_joblog where usercode = '"+usercode+"' and type='"+type+"'";
	
		try{
		conn = DBUtil.getConnection();
		prst = conn.prepareStatement(sql);
		System.out.println(sql);
		rs  = prst.executeQuery();
		while(rs.next()){
			Joblog jl = new Joblog();
			jl.setId(rs.getInt(1));
			jl.setUsercode(rs.getString(2));
			jl.setTimes(rs.getString(3));
			jl.setTitle(rs.getString(4));
			jl.setContend(rs.getString(5));
			jl.setRectime(rs.getString(6));
			jl.setType(rs.getString(7));
			datalist.add(jl);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return datalist;
	}
}
