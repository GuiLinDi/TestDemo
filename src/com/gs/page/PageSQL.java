package com.gs.page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gs.db.DBUtil;

public class PageSQL {
	public static int count = -1;
	public static String pageSql(String sql){
		return sql += " limit ?,?";
	}
	public static int getCount(String tablename,String wheresql){
		 count = 0;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stm = conn.createStatement();
			String sql = "select count(*) from "+tablename +"  "+wheresql;
			rs = stm.executeQuery(sql);
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return count;
	}
}