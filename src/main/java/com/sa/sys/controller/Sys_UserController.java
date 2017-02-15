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
import com.sa.sys.model.Sys_User;
import com.sa.sys.service.Sys_UserService;


/**
 * 
 * @描述 UserController 用户管理控制器
 * @author zss
 * @time 2016年12月4日下午2:29:56
 * @version 1.0
 */

@Controller
public class Sys_UserController {
	
	private  Map<String, Object> result;
	
	@Resource
	private Sys_UserService sys_userService;

	//添加用户
	@RequestMapping(value = "/addSys_User")
	public  String addSys_User(@ModelAttribute Sys_User sys_user,  HttpServletResponse response ,HttpSession session){
		Sys_User loginUser = sys_userService.getLoginSys_User(sys_user);
		if(loginUser==null){
			result = new HashMap<String, Object>();
			result.put("success", sys_userService.addSys_User(sys_user));
			return "redirect:/home";
		}else{
			return "redirect:/login";
		}
		
	}
	
	//查询用户列表，可以根据条件查询
	@RequestMapping(value = "/getSys_Users")
	public @ResponseBody String getSys_Users(@RequestParam Map<String, Object> params){
		result = new HashMap<String, Object>();
		result.put("list", sys_userService.getSys_Users(params));
		return JSON.toJSONString(result);
	}
}