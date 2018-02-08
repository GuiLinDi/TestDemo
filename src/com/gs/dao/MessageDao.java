package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.MessageBean;
import com.gs.db.DBUtil;
import com.gs.page.PageSQL;

public class MessageDao {
	
	public void add(MessageBean message) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into t_message(sender,receiver,content,sendtime) values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, message.getSender());
			pst.setString(2, message.getReceiver());
			pst.setString(3, message.getContent());
			pst.setString(4, message.getSendtime());
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
			String sql = "delete from t_message where id=?";
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
	
	public void update(MessageBean message) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update t_message set receiver=?,content=?,sendtime=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, message.getReceiver());
			pst.setString(2, message.getContent());
			pst.setString(3, message.getSendtime());
			pst.setInt(4, message.getId());
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	

public List pageSelect(String receiver,int beg,int pageSize){
		List list = new ArrayList();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql= "select * from t_message ";
			if(receiver!=null&&!receiver.equals("")){
				sql+=" where receiver= '"+receiver+"'";
			}
			sql = PageSQL.pageSql(sql);
			pst = conn.prepareStatement(sql);
			pst.setInt(1, beg);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				MessageBean message = new MessageBean();
				message.setId(rs.getInt(1));
				message.setSender(rs.getString(2));
				message.setReceiver(rs.getString(3));
				message.setContent(rs.getString(4));
				message.setSendtime(rs.getString(5));
				list.add(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
	
	public MessageBean selectById(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		MessageBean message = new MessageBean();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from t_message where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				message.setId(rs.getInt(1));
				message.setReceiver(rs.getString(3));
				message.setContent(rs.getString(4));
				message.setSendtime(rs.getString(5));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		return message;
	}
	
	/*public List pageSelect(String sender){
		List list = new ArrayList();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql= "select * from t_message ";
			if(sender!=null&&!sender.equals("")){
				sql+=" where id= '"+sender+"'";
			}
			sql = PageSQL.pageSql(sql);
			pst = conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				MessageBean message = new MessageBean();
				message.setId(rs.getInt(1));
				message.setSender(rs.getString(2));
				message.setReceiver(rs.getString(3));
				message.setContent(rs.getString(4));
				message.setSendtime(rs.getString(5));
				list.add(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}*/
}
