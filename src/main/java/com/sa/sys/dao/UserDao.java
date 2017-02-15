package com.sa.sys.dao;

import java.util.List;
import java.util.Map;

import com.sa.sys.model.User;


public interface UserDao {
	
	 Integer addUser(Map<String, Object> params);  //添加用户操作
	 
	 List<User> getUsers(Map<String, Object> params) ;  //查询系统用户列表，可根据条件查询
	 
	 User getLoginUser(Map<String, Object> params);  // 根据用户名和密码获取用户

	 List<String> getFunStrsByUserId(Map<String, Object> params);  // 根据用户的userid获得用户的权限列表

	 User getUserByUserName(Map<String, Object> params);  //根据用户名查询用户对象

	// User getUserByUserName(Map<String, Object> params);  //根据用户名查询用户对象
	 
	// List<String> getFunStrsByUserId(Map<String, Object> params);  // 根据用户的userid获得用户的权限列表
 
}
