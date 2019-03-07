package com.byzx.web.service;

import java.util.List;

import com.byzx.web.dao.DBHelper;
import com.byzx.web.vo.User;

public class UserService {

	DBHelper helper = new DBHelper();
	
	// 根据uid查user
	public User findUserById(int uid) {
		return helper.findUserById(uid);
	}
	// 全查user表
	public List<User> findAllUser(){
		return helper.findAllUser();
	}
	
	// 根据uid删除用户
	public int deleteUser(int uid) {
		return helper.deleteUser(uid);
	}
	
	// 添加用户
	public int insertUser(User user) {
		return helper.insertUser(user);
	}
	
	// 修改用户
	public int updateUser(User user) {
		return helper.updateUser(user);
	}
}
	
	
	
	
	
	
	
	
	
