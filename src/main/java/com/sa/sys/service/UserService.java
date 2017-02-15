package com.sa.sys.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sa.basic.base.BaseDao;
import com.sa.basic.base.BaseService;
import com.sa.basic.utils.UuidUtil;
import com.sa.sys.dao.UserDao;
import com.sa.sys.model.User;


@Service
public class UserService extends BaseService<User>{
	
	@Resource
	private  UserDao userDao;
	
	public boolean addUser(Map<String, Object> params) {
		params.put("userId", UuidUtil.uuid());
		return userDao.addUser(params)>0 ;
	}

	public List<User> getUsers(Map<String, Object> params) {
		return userDao.getUsers(params);
	}

	public User getLoginUser(Map<String, Object> params) {
		return userDao.getLoginUser(params);
	}

	@Override
	public BaseDao<User> getDao() {
		return null;
	}


	public User getUserByUserName(Map<String, Object> params) {
		return userDao.getUserByUserName(params);
	}

	public List<String> getFunStrsByUserId(Map<String, Object> params) {
		System.out.println("userId============"+params.get("userId"));
		return userDao.getFunStrsByUserId(params);
	}
	
}
