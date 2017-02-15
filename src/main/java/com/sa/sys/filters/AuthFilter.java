package com.sa.sys.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter  extends FormAuthenticationFilter {
	

	@Override
	protected UsernamePasswordToken createToken(ServletRequest request,
			ServletResponse response) {
	    String adminName = getUsername(request);
	    String adminPassword = getPassword(request);
	    boolean rememberMe = isRememberMe(request);
	    String host = getHost(request);
	    return new UsernamePasswordToken(adminName, adminPassword, rememberMe, 
	      host);
	}



	@Override
	protected boolean  executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		 UsernamePasswordToken token = createToken(request, response);
		 Subject subject =  getSubject(request, response);
		 boolean flag = true;
		 try {
			subject.login(token);  //登录，如果登录成功则没有异常抛出，如果登录不成功，则抛出登录不成功的异常
		} catch (Exception e) {
			 flag = false;
			e.printStackTrace();
		}
		 if(flag)
		return onLoginSuccess(token, subject, request, response); //如果登录正常，则返回登录成功的操作结果，也就是返回授权是否成功
		 else return false;
	}
 
}
