package com.sa.basic.base;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 描述：controller基类
 * @date 2016年5月7日 下午3:41:33
 * @author zss
 * @version 1.0
 */
public class BaseController extends BaseLogger{
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public String getPara(String name) {
		return getRequest().getParameter(name);
	}

	public String getPara(String name, String defaultValue) {
		String result = getRequest().getParameter(name);
		return result != null && !"".equals(result) ? result : defaultValue;
	}
	
	private Date toDate(String value, Date defaultValue) {
		if (value == null || "".equals(value.trim()))
			return defaultValue;
		try {
			return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public Date getParaToDate(String name) {
		return toDate(getRequest().getParameter(name), null);
	}

	public Date getParaToDate(String name, Date defaultValue) {
		return toDate(getRequest().getParameter(name), defaultValue);
	}

	protected Integer toInt(String value, Integer defaultValue) {
		if (value == null || "".equals(value.trim()))
			return defaultValue;
		if (value.startsWith("N") || value.startsWith("n"))
			return -Integer.parseInt(value.substring(1));
		return Integer.parseInt(value);
	}

	private Long toLong(String value, Long defaultValue) {
		if (value == null || "".equals(value.trim()))
			return defaultValue;
		if (value.startsWith("N") || value.startsWith("n"))
			return -Long.parseLong(value.substring(1));
		return Long.parseLong(value);
	}
	
	private Float toFloat(String value, Float defaultValue) {
		if (value == null || "".equals(value.trim()))
			return defaultValue;
		if (value.startsWith("N") || value.startsWith("n"))
			return -Float.parseFloat(value.substring(1));
		return Float.parseFloat(value);
	}
	
	public Long getParaToLong(String name) {
		return toLong(getRequest().getParameter(name), null);
	}

	public Integer getParaToInt(String name) {
		return toInt(getRequest().getParameter(name), null);
	}

	public Float getParaToFloat(String name) {
		return toFloat(getRequest().getParameter(name), null);
	}
	
	public Float getParaToFloat(String name,Float defaultValue) {
		return toFloat(getRequest().getParameter(name), defaultValue);
	}
	
	public Integer getParaToInt(String name, Integer defaultValue) {
		return toInt(getRequest().getParameter(name), defaultValue);
	}

	public Map<String, String[]> getParaMap() {
		return getRequest().getParameterMap();
	}


	public BaseController setAttr(String name, Object value) {
		getRequest().setAttribute(name, value);
		return this;
	}

	public  BaseController removeAttr(String name) {
		getRequest().removeAttribute(name);
		return this;
	}

	public  BaseController setAttrs(Map<String, Object> attrMap) {
		for (Map.Entry<String, Object> entry : attrMap.entrySet())
			getRequest().setAttribute(entry.getKey(), entry.getValue());
		return this;
	}
	
	public Date getParaToDateTime(String name) {
		return toDateTime(getPara(name), null);
	}

	public Date getParaToDateTime(String name, Date defaultValue) {
		return toDateTime(getPara(name), defaultValue);
	}

	public String getRequestURI() {
		return getRequest().getRequestURI();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public HttpSession getSession(boolean create) {
		return getRequest().getSession(create);
	}

	@SuppressWarnings("unchecked")
	public <T> T getSessionAttr(String key) {
		HttpSession session = getSession(false);
		return session != null ? (T) session.getAttribute(key) : null;
	}

	@ExceptionHandler
	public String exp(HttpServletRequest request, Exception e) {
		e.printStackTrace();
		request.setAttribute("e", e);
		logger.error(e.getMessage(), e);
		return "/error";
	}
	

	private Date toDateTime(String value, Date defaultValue) {
		if (value == null || "".equals(value.trim()))
			return defaultValue;
		try {
			return new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
