package com.byzx.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.byzx.web.vo.User;

public class DBUtils {

	// 获取数据库连接
	public static Connection getConn() {
		try {
			Class.forName(DBInfo.JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DBInfo.JDBC_URL, DBInfo.JDBC_USERNAME, DBInfo.JDBC_PASSWORD);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 查询user表
	public static List<User> findUser(String sql){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		return users;
	}
	
	// 修改表
	public static int updateTable(String sql) {
		int updateRows = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement(sql);
			updateRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, null);
		}
		return updateRows;
	}
	
	// 关闭流
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(null != rs) {
				rs.close();
			}
			if(null != ps) {
				ps.close();
			}
			if(null != conn && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}






















