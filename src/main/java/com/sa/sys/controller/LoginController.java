package com.sa.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sa.sys.model.Sys_User;
import com.sa.sys.service.Sys_UserService;


/**
 * 
 * @描述 LoginController 登录系统控制器
 * @author zss
 * @time 2016年12月4日下午2:29:16
 * @version 1.0
 */

//@Controller
//public class LoginController {
//	@RequestMapping(value="/login")
//	public String login(ServletRequest responce){
//		if ((SecurityUtils.getSubject().isRemembered()) || 
//	    	      (SecurityUtils.getSubject().isAuthenticated()))
//		return "redirect:/home"; 
//		return "login";
//	}
//}


@Controller
public class LoginController {
	
	@Resource
	private Sys_UserService sys_userService;
	@RequestMapping(value = "/login")
	public  String login(@ModelAttribute Sys_User sys_user,  HttpServletResponse response, HttpSession session){
		Sys_User loginUser = sys_userService.getLoginSys_User(sys_user);
		if(loginUser!=null){
			session.setAttribute("sys_user", loginUser);
          return "redirect:/home";
		}else{
		  return "login";
		}
	}
}
