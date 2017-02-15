package com.sa.sys.dao;

import java.util.List;
import java.util.Map;

import com.sa.sys.model.Sys_User;

public interface Sys_UserDao {
	
	 Integer addSys_User(Map<String, Object> params);  //添加用户操作
	 
	 List<Sys_User> getSys_Users(Map<String, Object> params) ;  //查询系统用户列表，可根据条件查询
	 
	 Sys_User getLoginSys_User(Map<String, Object> params);  // 根据用户名和密码获取用户

	 List<String> getFunStrsByAdminId(Map<String, Object> params);  // 根据用户的userid获得用户的权限列表

	 Sys_User getSys_UserByAdminName(Map<String, Object> params);  //根据用户名查询用户对象

	// User getUserByUserName(Map<String, Object> params);  //根据用户名查询用户对象
	 
	// List<String> getFunStrsByUserId(Map<String, Object> params);  // 根据用户的userid获得用户的权限列表
 
}
