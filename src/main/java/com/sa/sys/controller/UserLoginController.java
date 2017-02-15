package com.sa.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sa.sys.model.User;
import com.sa.sys.service.UserService;


/**
 * 
 * @描述 LoginController 登录系统控制器
 * @author zss
 * @time 2016年12月4日下午2:29:16
 * @version 1.0
 */

//@Controller
//public class UserLoginController {
//	@RequestMapping(value="/checkLogin")
//	public String login(ServletRequest responce){
//		if ((SecurityUtils.getSubject().isRemembered()) || 
//	    	      (SecurityUtils.getSubject().isAuthenticated()))
//		return "redirect:/manage/index.jsp"; 
//		return "login.jsp";
//	}
//}


@Controller
public class UserLoginController {
	
	@Resource
	private UserService userService;
	@RequestMapping(value = "/signon")
	public String addUser(@ModelAttribute User user,  HttpServletResponse response ,HttpSession session){
		User loginUser = userService.getLoginUser(user);
		if(loginUser!=null){
			session.setAttribute("user", loginUser);
			return "redirect:/manage/index.jsp";
		}else{
			return "redirect:/manage/signon.jsp";
		}
	}
	
}
