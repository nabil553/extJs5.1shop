package com.sa.sys.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sa.sys.model.User;
import com.sa.sys.service.UserService;


/**
 * 
 * @描述 UserController 用户管理控制器
 * @author zss
 * @time 2016年12月4日下午2:29:56
 * @version 1.0
 */

@Controller
public class UserController {
	
	private  Map<String, Object> result;
	
	@Resource
	private UserService userService;

	//注册用户
	@RequestMapping(value = "/addUser")
	public  String addUser(@ModelAttribute User user,  HttpServletResponse response ,HttpSession session){
		User loginUser = userService.getLoginUser(user);
		if(loginUser==null){
			result = new HashMap<String, Object>();
			result.put("success", userService.addUser(user));
			return "redirect:/manage/index.jsp";
		}else{
			return "redirect:/manage/register.jsp";
		}
	}
	
	//查询用户列表，可以根据条件查询
	@RequestMapping(value = "/getUsers")
	public @ResponseBody String getUsers(@RequestParam Map<String, Object> params){
		result = new HashMap<String, Object>();
		result.put("list", userService.getUsers(params));
		return JSON.toJSONString(result);
	}
}