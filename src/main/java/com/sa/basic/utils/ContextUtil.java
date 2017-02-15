package com.sa.basic.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ContextUtil {
	
	  public static HttpServletRequest getCurRequest()
	  {
	    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
	    if ((requestAttributes != null) && ((requestAttributes instanceof ServletRequestAttributes))) {
	      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttributes;
	      return servletRequestAttributes.getRequest();
	    }
	    return null;
	  }

	  public static HttpSession getCurSession() {
	    return getCurRequest().getSession();
	  }

}
