package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.upFile;
import com.gs.db.DBUtil;

public class FileDao {
	public void add(upFile file){
		Connection conn = null;
		PreparedStatement prst = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into t_upfile(filename,fileuper,filetime,fileinfo) values(?,?,?,?)";
			prst = conn.prepareStatement(sql);
			prst.setString(1, file.getFilename());
			prst.setString(2, file.getFileuper());
			prst.setString(3, file.getFiletime());
			prst.setString(4, file.getFileinfo());
			prst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	public List select(){
		Connection conn = null;
		PreparedStatement prst = null;
		List datalist = new ArrayList();
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from t_upfile";
			prst = conn.prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			while(rs.next()){
				upFile uf = new upFile();
				uf.setId(rs.getInt(1));
				uf.setFilename(rs.getString(2));
				uf.setFileuper(rs.getString(3));
				uf.setFiletime(rs.getString(4));
				uf.setFileinfo(rs.getString(5));
				datalist.add(uf);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return datalist;
	}
	public void delete(String fi){
		Connection conn = null;
		PreparedStatement prst = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "delete from t_upfile where fileinfo = ?";
			prst = conn.prepareStatement(sql);
			prst.setString(1, fi);
			prst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	public String selectformat(String fileinfo){
		Connection conn = null;
		PreparedStatement prst = null;
		String filename = "";
		try{
			conn = DBUtil.getConnection();
			String sql = "select filename from t_upfile where fileinfo = '"+ fileinfo+"'";
			prst = conn.prepareStatement(sql);
			ResultSet rs = prst.executeQuery(); 
			while(rs.next()){
				filename = rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return filename;
	}
}
