package com.sa.sys.realm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.sa.sys.model.Sys_User;
import com.sa.sys.service.Sys_UserService;


public class MyRealm extends AuthorizingRealm{

	@Resource
	private Sys_UserService sys_userService;
	
	//授权, 该操作由shiro授权的注解来启动，多个授权的注解可以多次调用该方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		Session session  = SecurityUtils.getSubject().getSession();
		Map<String, Object> params = new HashMap<String, Object>();
		Sys_User sys_user = (Sys_User)session.getAttribute("sys_user");
		params.put("adminId", sys_user.getAdminId() );
		List<String> funs = sys_userService.getFunStrsBySys_UserId(params);
		simpleAuthorizationInfo.addStringPermissions(funs);
		//simpleAuthorizationInfo.addRoles(roles);
		return simpleAuthorizationInfo;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticattionToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)authenticattionToken;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("adminName", token.getUsername());
		Sys_User sys_user = sys_userService.getUserBySys_UserName(params);
		setSession( "sys_user", sys_user);
		return new SimpleAuthenticationInfo(sys_user.getAdminName(), sys_user.getAdminPwd(), "abc");
	
	}
	
	
	//设置session
  private void setSession(Object key, Object value)
  {
    Subject currentUser = SecurityUtils.getSubject();
    if (currentUser != null) {
      Session session = currentUser.getSession();
      if (session != null)
        session.setAttribute(key, value);
    }
  }

}