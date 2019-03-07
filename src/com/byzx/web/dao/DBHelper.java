package com.byzx.web.dao;

import java.util.List;

import com.byzx.web.vo.User;

public class DBHelper {

	// 根据uid查user
	public User findUserById(int uid) {
		String sql = "select * from user where uid=" + uid;
		List<User> users = DBUtils.findUser(sql);
		return users.size()==0?null:users.get(0);
	}
	// 根据用户名查user
	public User findUserByName(String username) {
		String sql = "select * from user where uname='" + username + "'";
		List<User> users = DBUtils.findUser(sql);
		
		
		
		return users.size()==0?null:users.get(0);
	}
	
	// 全查user表
	public List<User> findAllUser(){
		String sql = "select * from user";
		return DBUtils.findUser(sql);
	}
	
	// 根据uid删除用户
	public int deleteUser(int uid) {
		String sql = "delete from user where uid=" + uid;
		return DBUtils.updateTable(sql);
	}
	
	// 添加用户
	public int insertUser(User user) {
		String sql = "insert into user values("+user.getUid()+",'"+user.getUname()+"','"+user.getPassword()+"','"+user.getSex()+"','"+user.getPhone()+"','"+user.getAddress()+"')";
		return DBUtils.updateTable(sql);
	}
	
	// 修改用户
	public int updateUser(User user) {
		String sql = "update user set uname='"+user.getUname()+"',password='"+user.getPassword()+"',sex='"+user.getSex()+"',phone='"+user.getPhone()+"',address='"+user.getAddress()+"' where uid=" + user.getUid();
		System.out.println(sql);
		return DBUtils.updateTable(sql);
	}
	
	public static void main(String[] args) {
		DBHelper helper = new DBHelper();
		helper.findUserByName("scottqq");
	}
}










