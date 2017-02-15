package com.sa.sys.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sa.basic.base.BaseDao;
import com.sa.basic.base.BaseService;
import com.sa.basic.utils.UuidUtil;
import com.sa.sys.dao.Sys_UserDao;
import com.sa.sys.model.Sys_User;


@Service
public class Sys_UserService extends BaseService<Sys_User>{
	
	@Resource
	private  Sys_UserDao sys_userDao;
	//添加用户
	public boolean addSys_User(Map<String, Object> params) {
		params.put("adminId", UuidUtil.uuid());
		return sys_userDao.addSys_User(params)>0 ;
	}
	//根据条件查询系统用户
	public List<Sys_User> getSys_Users(Map<String, Object> params) {
		return sys_userDao.getSys_Users(params);
	}
	//根据系统用户登录系统用户
	public Sys_User getLoginSys_User(Map<String, Object> params) {
		return sys_userDao.getLoginSys_User(params);
	}
	
	//根据系统用户名获得用户
	public Sys_User getUserBySys_UserName(Map<String, Object> params) {
		return sys_userDao.getSys_UserByAdminName(params);
	}
	//根据用户的userId获得用户权限列表
	public List<String> getFunStrsBySys_UserId(Map<String, Object> params) {
		return sys_userDao.getFunStrsByAdminId(params);
	}


	@Override
	public BaseDao<Sys_User> getDao() {
		return null;
	}


//	public User getUserByUserName(Map<String, Object> params) {
//		return userDao.getUserByUserName(params);
//	}
//
//	public List<String> getFunStrsByUserId(Map<String, Object> params) {
//		System.out.println("userId============"+params.get("userId"));
//		return userDao.getFunStrsByUserId(params);
//	}
	
}
